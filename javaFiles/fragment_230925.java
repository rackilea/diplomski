@Path("/multipart")
public class MutlipartResource {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response postMultiPart(@FormDataParam("date") String date, 
                                  @FormDataParam("filepath") InputStream stream) 
                                                               throws Exception {
        ImageIO.read(stream);
        return Response.ok(date).build();
    }
}