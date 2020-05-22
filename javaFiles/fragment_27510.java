@Bean
public IntegrationFlow advised() {
    return f -> f.handle((GenericHandler<String>) (payload, headers) -> {
        if (payload.equals("good")) {
            return null;
        }
        else {
            throw new RuntimeException("some failure");
        }
    }, c -> c.advice(expressionAdvice()));
}

@Bean
public Advice expressionAdvice() {
    ExpressionEvaluatingRequestHandlerAdvice advice = new ExpressionEvaluatingRequestHandlerAdvice();
    advice.setSuccessChannelName("success.input");
    advice.setOnSuccessExpressionString("payload + ' was successful'");
    advice.setFailureChannelName("failure.input");
    advice.setOnFailureExpressionString(
            "payload + ' was bad, with reason: ' + #exception.cause.message");
    advice.setTrapException(true);
    return advice;
}

@Bean
public IntegrationFlow success() {
    return f -> f.handle(System.out::println);
}

@Bean
public IntegrationFlow failure() {
    return f -> f.handle(System.out::println);
}