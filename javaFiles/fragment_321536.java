@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response upload(@FormDataParam("file") InputStream inputStream,
                       @FormDataParam("file") FormDataContentDisposition fileMetaData) {
    ...
}