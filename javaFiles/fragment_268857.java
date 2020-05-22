public void handleReturnValue(
        Object returnValue, MethodParameter returnType,
        ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
        throws Exception {

    HandlerMethodReturnValueHandler handler = getReturnValueHandler(returnType); // returns the appropriate handler
    Assert.notNull(handler, "Unknown return value type [" + returnType.getParameterType().getName() + "]");
    handler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
}