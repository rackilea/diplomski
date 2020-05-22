@Component
public class SpringSessionClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

@Override
public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
    throws IOException {

    request.getHeaders().add("Cookie", "SESSION=" + sessionId);
    return execution.execute(request, body);
}