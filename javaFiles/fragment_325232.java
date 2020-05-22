abstract class RequestCloner {

  private enum RequestType {
    GET(new GetRequestCloner()),
    POST(new PostRequestCloner()),
    DELETE(new DeleteRequestCLoner());

    private final RequestCloner requestCloner;

    private RequestType(RequestCloner requestCloner) {
      this.requestCloner = requestCloner();
    }
  }

  public static HttpUriRequest cloneRequest(HttpServletRequest servletRequest)
        throws IOException {
    RequestType requestType = RequestType.valueOf(servletRequest. getMethod());
    String uri = servletRequest.getRequestURI();
    return requestType.requestCloner.clone(uri, servletRequest);
  }

  ...
}