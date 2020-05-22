public class ResponseInterceptor implements ClientHttpRequestInterceptor {

final static Logger log = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

@Override
public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    ClientHttpResponse response = execution.execute(request, body);
    //add your code
    if(response.getBody() == customErrorMessage){ // TODO 
      thrown new Exception("customErrorMessage");
    }
    return response;
}