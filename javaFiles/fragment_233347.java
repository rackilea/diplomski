@POST
@Path("/remove")
public Response removeUserId(@FormParam("uid") int uid) throws Exception {
    // remove the user
    FormData test = new FormData();
    test.removeUser(uid); // you may want to use the return to indicate a success/failure

    // redirect
    URI uri = uriInfo.getBaseUriBuilder().path("removeUser/index.jsp").build();
    return Response.seeOther(uri).build();
}