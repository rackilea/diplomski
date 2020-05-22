@Produces("text/plain")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(
    @FormDataParam("file") InputStream fileInputStream,
    @HeaderParam("Filename") String Filename) {
    String uploadedFileLocation = "D://FileUpload/" + Filename;
    ImageUpload filewrite = new ImageUpload();


   // if(error==true) return Response.status(400).build();
    return Response.ok().entity("job done").build();
}