public class SleuthWorkAroundInterceptor extends ChannelInterceptorAdapter {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        if (!(message instanceof ErrorMessage)) {
            return message;
        }
        MessagingException payload = (MessagingException) message.getPayload();
        Message<?> failedMessage = payload.getFailedMessage();
        failedMessage = MessageBuilder.fromMessage(failedMessage)
                .removeHeader(MessageHeaders.REPLY_CHANNEL)
                .removeHeader(MessageHeaders.ERROR_CHANNEL)
                .build();
        return new ErrorMessage(new MessagingException(failedMessage, payload), message.getHeaders());
    }

}