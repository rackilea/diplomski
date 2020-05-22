@Override
public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.configureBrokerChannel().interceptors(new YourInterceptor())
    registry.enableSimpleBroker("/queue/", "/topic/");
    registry.setApplicationDestinationPrefixes("/app");
}