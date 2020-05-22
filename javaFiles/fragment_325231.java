class PostRequestCloner extends RequestCloner {
  private static final int MAX_STR_LEN = 1024;

  @Override
  protected HttpPost clone(
      String uri, HttpServletRequest servletRequest)
      throws IOException {
    HttpPost clonedRequest = new HttpPost(uri);
    cloneHeaders(servletRequest, clonedRequest);
    cloneBody(servletRequest, clonedRequest);
    return clonedRequest;
  }

  ...
}