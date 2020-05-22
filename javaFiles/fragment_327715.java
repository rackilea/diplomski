class SubscribeExtension extends ClientSession.Extension.Adapter {
    @Override
    public boolean sendMeta(ClientSession session, Message.Mutable message) {
        if (Channel.META_SUBSCRIBE.equals(message.getChannel())) {
            String subscription = (String)message.get(Message.SUBSCRIPTION_FIELD);
            if (subscription.startsWith("/chat/") {
                // Add fields.
            }
        }
        return true;
    }
}