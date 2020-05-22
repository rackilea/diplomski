@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Path("someurl/{fileName}")
public Artifact uploadArtifact(
    @FormDataParam("file") InputStream uploadedStream,
    @FormDataParam("file") FormDataContentDisposition fileDetails,
    @PathParam("fileName") String fileName) throws Exception;