//SimpleBrokerMessageHandler doesn't support RECEIPT frame, hence we emulate it this way
    @Bean
    public ApplicationListener<SessionSubscribeEvent> webSocketEventListener(
            final AbstractSubscribableChannel clientOutboundChannel) {
        return event -> {
            Message<byte[]> message = event.getMessage();
            StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(message);
            if (stompHeaderAccessor.getReceipt() != null) {
                stompHeaderAccessor.setHeader("stompCommand", StompCommand.RECEIPT);
                stompHeaderAccessor.setReceiptId(stompHeaderAccessor.getReceipt());
                clientOutboundChannel.send(
                        MessageBuilder.createMessage(new byte[0], stompHeaderAccessor.getMessageHeaders()));
            }
        };
    }