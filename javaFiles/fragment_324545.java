.handle(validationErrorHandler())

...

@Bean
public MessageHandler validationErrorHandler() {
    return new AbstractReplyProducingMessageHandler() {
        public Object handleRequestMessage(Message<?> error) {
            MyValidationException myEx = (MyValidationException) 
                  ((ErrorMessage) error).getPayload.getCause();
            Errors errors = myEx.getErrors();
            ...
        }
    }
}