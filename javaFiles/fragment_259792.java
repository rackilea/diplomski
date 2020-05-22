@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(
    @FormDataParam("file") InputStream uploadedInputStream,
    @FormDataParam("file") FormDataContentDisposition fileDetail) {

    String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

    // save it
    writeToFile(uploadedInputStream, uploadedFileLocation);

    String output = "File uploaded to : " + uploadedFileLocation;

    return Response.status(200).entity(output).build();
}