@SpringBootApplication
@EnableBinding(Source.class)
public class So44018382Application implements CommandLineRunner {

    final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So44018382Application.class, args);
        Thread.sleep(60_000);
        context.close();
    }

    @RabbitListener(bindings =
            @QueueBinding(value = @Queue(value = "foo", autoDelete = "true"),
                            exchange = @Exchange(value = "output", type = "topic"), key = "#"))
    // bind a queue to the output exchange
    public void listen(String in) {
        this.logger.info("received " + in);
    }

    @BridgeTo(value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "2"))
    @Bean
    public PollableChannel polled() {
        return new QueueChannel(5);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 30; i++) {
            polled().send(new GenericMessage<>("foo" + i));
            this.logger.info("sent foo" + i);
        }
    }

}