@Provider
@ContentTypeFilterAnnotation
public class ContentTypeFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    MultivaluedMap<String,String> headers = requestContext.getHeaders();
    List<String> contentType = headers.get(HttpHeaders.CONTENT_TYPE);
    // if MediaType.APPLICATION_FORM_URLENCODED is not present in the content type header, return a 400
    if(contentType == null || !contentType.contains(MediaType.APPLICATION_FORM_URLENCODED)) {
      // build your error as you want it
      Response.ResponseBuilder responseBuilder = Response.serverError();
      Response response = responseBuilder.status(Response.Status.BAD_REQUEST).build();
      requestContext.abortWith(response);
    }
  }
}