private Message<?> createReplyMessage(Object reply, MessageHeaders requestHeaders) {
    AbstractIntegrationMessageBuilder<?> builder = null;
    if (reply instanceof Message<?>) {
        if (!this.shouldCopyRequestHeaders()) {
            return (Message<?>) reply;
        }
        builder = this.getMessageBuilderFactory().fromMessage((Message<?>) reply);
    }

...

    if (this.shouldCopyRequestHeaders()) {
        builder.copyHeadersIfAbsent(requestHeaders);
    }
    return builder.build();
}