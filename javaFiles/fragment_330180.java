public class Controller {
    @Path("/submitFile")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
        @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail) {}

    @Path("/image/getPictureById/{imageId}")
    @GET
    @Produces("image/png")
    public Response getPictureById(@PathParam("imageId") String imageId){}