@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
  @Path("foo")
  public Object foo(Model bar) throws CustomException {
    // do parsing and return response
    JSONObject response = fooBar.handleRequest(bar);
    return response;
  }