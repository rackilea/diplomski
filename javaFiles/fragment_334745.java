@GET
public Response check(@QueryParam("username") String username) {
   if (facade.checkUser(username)) {
      return Response.status(Response.Status.NOT_FOUND).build();
   }
   return Response.ok().build();
}