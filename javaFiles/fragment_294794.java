@Path("/testpath")
public class test {
    @POST
    @Path("/level1")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response getData(MultiValuedMap<String, String> params) {
        StringBuilder sb = new StringBuilder("getData is called, ");
        for(String param : params.keySet()) {
            sb.append(param + " : " + params.getFirst(param) + ", ");
        }
        return Response.status(200).entity(sb.toString()).build();
    }
}