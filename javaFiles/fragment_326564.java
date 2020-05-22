@Override
public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
      java.lang.Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
      ServerHttpResponse response) {
    int status = HttpStatus.OK.value();
    if (response instanceof ServletServerHttpResponse) {
      status = ((ServletServerHttpResponse) response).getServletResponse().getStatus();
    }
    response.setStatusCode(HttpStatus.OK);
    return ResponseEntity.status(HttpStatus.valueOf(status)).body(body);
}