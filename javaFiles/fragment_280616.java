@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public void deletePathParam(@PathParam("id") int id) {
  ...
}