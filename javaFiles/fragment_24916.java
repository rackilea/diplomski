public class EmptyListRequestHandlerAdvice extends AbstractRequestHandlerAdvice {

    private final MessagingTemplate messagingTemplate = new MessagingTemplate();

    public EmptyListRequestHandlerAdvice(MessageChannel emptyListChannel) {
         this.messagingTemplate.setDefaultChannel(emptyListChannel);
    }

    @Override
    protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
          Collection<?> result = (Collection<?>) callback.execute();
          if (result.isEmpty) {
             this.messagingTemplate.convertAndSend(result);
          }
          return result;
     }

}