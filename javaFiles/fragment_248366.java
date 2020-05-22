@ConditionalOnWebApplication
@Configuration
public class WebSocketConfigurator implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/").setAllowedOrigins("*");
    }

    @Bean
    public SpringWebSocketHandler myHandler() {
        return new SpringWebSocketHandler();
    }
}