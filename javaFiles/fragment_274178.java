public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    TResult result = TResult.success(o);
    // just change the value
    if (o instanceof String) {
        return JSON.toJSONString(result);
    }
    return result;
}