@Path("/api-java")
public interface IServices {

    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response putservice(ApiRequestModel api);
}