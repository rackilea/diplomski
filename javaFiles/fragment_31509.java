@GET
@Path("json/{fullAlias}")
public Response json(@PathParam("fullAlias") String fullAlias, @Context MessageContext req) {
    ...
    if (success) {
        ResponseBuilder rBuild = Response.ok(responseData, MediaType.APPLICATION_JSON);
        return rBuild.build();
    }
    else {
        ResponseBuilder rBuild = Response.status(Response.Status.BAD_REQUEST);
        return rBuild.type(MediaType.TEXT_PLAIN)
                     .entity("error message")
                     .build();
    }    
}