@Bean
public RequestHandlerRetryAdvice retryAdvice() {
    RequestHandlerRetryAdvice requestHandlerRetryAdvice = new RequestHandlerRetryAdvice();
    requestHandlerRetryAdvice.setRecoveryCallback(new ErrorMessageSendingRecoverer(recoveryChannel()));
    return requestHandlerRetryAdvice;
}