public class LengthInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {

        ClientHttpResponse response = execution.execute( request, body );
        long length = response.getHeaders().getContentLength();
        // do something with length
        return response;
    }
}