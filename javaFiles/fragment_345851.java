@SpringBootApplication
public class So54057281Application {

    public static void main(String[] args) {
        SpringApplication.run(So54057281Application.class, args);
    }

    @Bean
    public IntegrationFlow server() {
        return IntegrationFlows.from(Tcp.inboundGateway(
                    Tcp.netServer(1234)
                        .serializer(codec()) // default is CRLF
                        .deserializer(codec()))) // default is CRLF
                .transform(Transformers.objectToString()) // byte[] -> String
                .<String, String>transform(p -> p.toUpperCase())
                .get();
    }

    @Bean
    public IntegrationFlow client() {
        return IntegrationFlows.from(MyGateway.class)
                .handle(Tcp.outboundGateway(
                    Tcp.netClient("localhost", 1234)
                        .serializer(codec()) // default is CRLF
                        .deserializer(codec()))) // default is CRLF
                .transform(Transformers.objectToString()) // byte[] -> String
                .get();
    }

    @Bean
    public AbstractByteArraySerializer codec() {
        return TcpCodecs.lf();
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    public interface MyGateway {

        String exchange(String out);

    }

}