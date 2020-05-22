@POST
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/post1")
public ResponseBean post1(Data param1)
{
    return ResponseFactory.createResponse(param1, "TEST", "TEST", null, true);
}