@GET
@Path("{userId}")
@Produces(MediaType.APPLICATION_JSON)
public User getActivityUser(@PathParam("userId") String userId) {
  //Code goes here

}