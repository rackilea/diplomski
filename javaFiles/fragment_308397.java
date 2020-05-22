@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    private final static String userDestinationPrefix = "/ws-user/";

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/ws-topic","/ws-user");
        config.setApplicationDestinationPrefixes("/ws-app");
        config.setUserDestinationPrefix(userDestinationPrefix);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-notification").setAllowedOrigins("*").withSockJS();
    }
}