@Configuration
@EnableWebMvc
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Main.class)
                .run(args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer customizer() throws MalformedURLException {

        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof JettyEmbeddedServletContainerFactory) {
                    customizeJetty((JettyEmbeddedServletContainerFactory) container);
                }
            }

            private void customizeJetty(JettyEmbeddedServletContainerFactory jetty) {
                jetty.addServerCustomizers((JettyServerCustomizer) server -> {
                    HandlerCollection handlerCollection = new HandlerCollection();
                    handlerCollection.setHandlers(new Handler[]{ myCustomHandler(), server.getHandler() });
                    server.setHandler(handlerCollection);
                });
            }
        };

    }
}