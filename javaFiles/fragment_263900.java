@Configuration
    @EnableWebSocketMessageBroker
    public class MyConfig implements WebSocketMessageBrokerConfigurer {

        @Override
        public void configureClientInboundChannel(ChannelRegistration registration) {
            registration.interceptors(new ChannelInterceptor() {
                @Override
                public Message<?> preSend(Message<?> message, MessageChannel channel) {
                    StompHeaderAccessor accessor =
                            MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                    if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                        Authentication user = ... ; // access authentication header(s)
                        accessor.setUser(user);
                    }
                    return message;
                }
            });
        }
    }