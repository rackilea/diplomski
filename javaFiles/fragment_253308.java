@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(FormDataMultiPart formDataMultiPart) {
     FormDataBodyPart filePart = formDataMultiPart.getField("file");         
     InputStream fileInputStream = filePart.getValueAs(InputStream.class);
     .
     .
     .
}