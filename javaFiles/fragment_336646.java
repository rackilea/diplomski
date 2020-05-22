@SpringBootApplication
public class So43983296Application implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So43983296Application.class, args);
        Thread.sleep(10_000);
        context.close();
    }

    @Autowired
    private DefaultTcpNetSSLSocketFactorySupport ssl;

    @Override
    public void run(String... args) throws Exception {
        Socket socket = ssl.getSocketFactory().createSocket("localhost", 1234);
        socket.getOutputStream().write("foo\r\n".getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();
        System.out.println(result);
        br.close();
        socket.close();
    }

    @Bean
    public TcpNetServerConnectionFactory scf() {
        TcpNetServerConnectionFactory scf = new TcpNetServerConnectionFactory(1234);
        DefaultTcpNetSSLSocketFactorySupport tcpSocketFactorySupport = tcpSocketFactorySupport();
        scf.setTcpSocketFactorySupport(tcpSocketFactorySupport);
        // Add custom serializer/deserializer here; default is ByteArrayCrLfSerializer
        return scf;
    }

    @Bean
    public DefaultTcpNetSSLSocketFactorySupport tcpSocketFactorySupport() {
        TcpSSLContextSupport sslContextSupport = new DefaultTcpSSLContextSupport("classpath:test.ks",
                "classpath:test.truststore.ks", "secret", "secret");
        DefaultTcpNetSSLSocketFactorySupport tcpSocketFactorySupport =
                new DefaultTcpNetSSLSocketFactorySupport(sslContextSupport);
        return tcpSocketFactorySupport;
    }

    @Bean
    public TcpInboundGateway inGate() {
        TcpInboundGateway inGate = new TcpInboundGateway();
        inGate.setConnectionFactory(scf());
        inGate.setRequestChannelName("upperCase");
        return inGate;
    }

    @ServiceActivator(inputChannel = "upperCase")
    public String upCase(byte[] in) {
        return new String(in).toUpperCase();
    }

}