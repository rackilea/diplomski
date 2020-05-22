public class HttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
      IOException cause = exception;
      if (exception instanceof SSLException) {
        if (exception.getCause() != null && exception.getCause() instanceof IOException) {
          cause = (IOException) exception.getCause();
        }
      }
      return super.retryRequest(cause, executionCount, context);
    }
  }