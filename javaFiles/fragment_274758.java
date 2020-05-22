@ControllerAdvice
public class OauthReponseAdvice implements ResponseBodyAdvice<SomeResponseType> {
@Override
public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
}

@Override
public SomeResponseType beforeBodyWrite(SomeResponseType body, MethodParameter returnType, MediaType selectedContentType, Class<? extends
HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

     /// Modify body here
    return body;
   }
}