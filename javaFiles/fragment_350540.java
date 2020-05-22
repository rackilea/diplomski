@POST
@Path("/save")
@Consumes("application/x-www-form-urlencoded")
public Response saveS(@FormParam(key) String value) throws SQLException {           
    return Response.ok("TODO", MediaType.APPLICATION_JSON).build();
}