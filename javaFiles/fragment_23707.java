@ControllerAdvice
public class CustomerResponseFilter implements ResponseBodyAdvice<ResponseEntity<Customer>> {

    @Override
    public boolean supports(MethodParameter returnType,
        Class<? extends HttpMessageConverter<?>> converterType) {
    // TODO Auto-generated method stub
    return false;
    }

    @Override
    public ResponseEntity<Customer> beforeBodyWrite(ResponseEntity<Customer> body,
        MethodParameter returnType, MediaType selectedContentType,
        Class<? extends HttpMessageConverter<?>> selectedConverterType,
        ServerHttpRequest request, ServerHttpResponse response) {

    //..do your manipulations 
    return body;
    }

}