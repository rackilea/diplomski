@Bean
public Advice expressionAdvice() {
    ExpressionEvaluatingRequestHandlerAdvice advice = new ExpressionEvaluatingRequestHandlerAdvice();
    advice.setOnFailureExpressionString("@acceptOnceFileListFilter.remove(payload)");
    advice.setTrapException(true);
    return advice;
}

...

@ServiceActivator(inputChannel = "ftpChannel", adviceChain = "expressionAdvice")