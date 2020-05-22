@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory getEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory();
        containerFactory
                .addConnectorCustomizers(new TomcatConnectorCustomizer() {
                    @Override
                    public void customize(Connector connector) {
                        ((AbstractProtocol) connector.getProtocolHandler()).setConnectionTimeout(100);
                    }
                });

        return containerFactory;
    }

    @RequestMapping
    public String echo(@RequestBody String body) {
        return body;
    }
}