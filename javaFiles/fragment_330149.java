@GET
@Path("/{param}")
public Response getResource(@PathParam("param") String id, @HeaderParam(
"SendBackUri") String uri) {
    executorService.execute(new Runnable() {
       public void run() {
          Resource res = SomeBean().getResource(id);
          Response response = ClientBuilder.newClient().target(uri).request().buildPost(Entity.entity(res, MediaType.WILDCARD_TYPE)).invoke();
          //deal with response
       }
    });
    return Response.status(202).build();
}