public class ResultResponseHandlerMethodProcessor extends RequestResponseBodyMethodProcessor {
    public ResultResponseHandlerMethodProcessor(final List<HttpMessageConverter<?>> messageConverters) {
        super(messageConverters);
    }

    public ResultResponseHandlerMethodProcessor(final List<HttpMessageConverter<?>> messageConverters, final ContentNegotiationManager contentNegotiationManager) {
        super(messageConverters, contentNegotiationManager);
    }

    @Override
    public boolean supportsReturnType(final MethodParameter returnType) {
        return returnType.getMethodAnnotation(ResultResponseBody.class) != null;
    }

    @Override
    public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException {
        super.handleReturnValue(Result.ok(returnValue), returnType, mavContainer, webRequest);
    }
}