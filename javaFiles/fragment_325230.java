abstract class RequestCloner {

  private enum RequestType {
    GET, POST, DELETE
  }

  public static HttpUriRequest cloneRequest(HttpServletRequest servletRequest)
        throws IOException {
    RequestCloner cloner = createCloner(servletRequest);
    String uri = servletRequest.getRequestURI();
    return cloner.clone(uri, servletRequest);
  }

  private static RequestCloner createCloner(HttpServletRequest servletRequest) {
    RequestType requestType = RequestType.valueOf(servletRequest. getMethod());
    switch (requestType) {
    case GET:
      return new GetRequestCloner();
    case POST:
      return new PostRequestCloner();
    case DELETE:
      return new DeleteRequestCloner();
    default:
      throw new AssertionFailedError(String.format(
          "RequestType '%s' not supported", requestType));
    }
  }

  protected abstract HttpUriRequest clone(
      String uri, HttpServletRequest servletRequest)
      throws IOException;

  protected final void cloneHeaders(
      HttpServletRequest servletRequest,
      HttpUriRequest clonedRequest) { // note addition of parameter
    // same code as before, but modify the passed-in clonedRequest
  }
}