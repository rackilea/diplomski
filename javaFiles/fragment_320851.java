@POST
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public Response makeRequest(Request req) {
    Response res = new Response();
    res.setName(req.getName());
    return Response.entity(res).status(Response.Status.CREATED).build();
}