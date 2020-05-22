@GET
@Path("/{param}")
public Response getResource(@PathParam("param") String id, @HeaderParam(
"SendBackUri") String uri) {
    new Thread() {
       public void run() {
          Resource res = SomeBean().getResource(id);
          ClientBuilder.newClient().target(uri).request().buildPost(Entity.entity(res, MediaType.WILDCARD_TYPE)).invoke();
       }
    }.start();
    return Response.status(202).build();
}