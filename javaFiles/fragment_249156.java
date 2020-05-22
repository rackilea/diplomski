@SpringBootApplication
public class So46917862Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(So46917862Application.class);

    public static void main(String[] args) {
        SpringApplication.run(So46917862Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            Socket socket = SocketFactory.getDefault().createSocket("localhost", 1234);
            socket.getOutputStream().write("foo\r\n".getBytes());
            socket.getOutputStream().write("bar\r\n".getBytes());
            Thread.sleep(10_000);
            socket.close();
        };
    }

    @Bean
    public TcpReceivingChannelAdapter adapter() {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(server());
        adapter.setOutputChannel(inbound());
        return adapter;
    }

    @Bean
    public MessageChannel inbound() {
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "inbound")
    @Bean
    public MessageHandler asyncResponder() {
        SimpleAsyncTaskExecutor exec = new SimpleAsyncTaskExecutor();
        return m ->
            exec.execute(() -> {
                LOGGER.info("Initiating on this thread");
                toTcp().send(new GenericMessage<>("FOO", m.getHeaders()));
            });
    }

    @Bean
    public AbstractServerConnectionFactory server() {
        return new TcpNetServerConnectionFactory(1234);
    }

    @ServiceActivator(inputChannel = "outbound")
    @Bean
    public TcpSendingMessageHandler handler() {
        TcpSendingMessageHandler handler = new TcpSendingMessageHandler();
        handler.setConnectionFactory(server());
        return handler;
    }

    @Bean
    public MessageChannel toTcp() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outbound() {
        return new DirectChannel();
    }

    @Bean
    public SingleThreadPerConnection sender() {
        return new SingleThreadPerConnection(outbound());
    }

    public static class SingleThreadPerConnection implements ApplicationListener<TcpConnectionCloseEvent> {

        private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadPerConnection.class);

        private final Map<String, ThreadPoolTaskExecutor> executors = new HashMap<>();

        private final MessagingTemplate messagingTemplate;

        public SingleThreadPerConnection(MessageChannel channel) {
            this.messagingTemplate = new MessagingTemplate(channel);
        }

        @Override
        public synchronized void onApplicationEvent(TcpConnectionCloseEvent event) {
            this.executors.remove(event.getConnectionId()).shutdown();
            LOGGER.info("Removed executor for " + event.getConnectionId());
        }

        @ServiceActivator(inputChannel = "toTcp")
        public void sendToThread(final Message<?> message) {
            executorFor((String) message.getHeaders().get(IpHeaders.CONNECTION_ID))
                .execute(() -> {
                    LOGGER.info("Sending on this thread");
                    this.messagingTemplate.send(message);
                });
        }

        private synchronized TaskExecutor executorFor(String connectionId) {
            Assert.state(connectionId != null, "No connection id header present");
            if (this.executors.get(connectionId) == null) {
                ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
                exec.setThreadNamePrefix(connectionId + "-exec-");
                exec.initialize();
                this.executors.put(connectionId, exec);
            }
            return this.executors.get(connectionId);
        }

    }

}