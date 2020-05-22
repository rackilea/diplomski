@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

@Autowired
private WebSocketAuthInterceptorAdapter authInterceptorAdapter;


@Override
public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
}

@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/app").withSockJS();
}

@Override
public void configureClientInboundChannel(ChannelRegistration registration) {
    registration.setInterceptors(authInterceptorAdapter);
    super.configureClientInboundChannel(registration);
}
}