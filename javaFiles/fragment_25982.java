@GET
@PATH("/user")
@HandleMyOwnException
public Response getUser(@QueryParam("id") String userId) {
   assertNotNull(userId);
   return Response.ok(service.getUser(userId)).build();
}