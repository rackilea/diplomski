public class VariousErrorsResponseHandler implements ResponseErrorHandler {
@Override
public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
    if(clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND || clientHttpResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) return false;
    else return true;
}

@Override
public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
    System.err.println(clientHttpResponse.getStatusCode() + "\n" + clientHttpResponse.getStatusText());
}
}