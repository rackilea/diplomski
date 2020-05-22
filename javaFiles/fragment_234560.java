@POST
@Secure
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response upload(/*other parms */,  @FormDataParam("fileaaa") final FormDataBodyPart body) {
   String mimeType = body.getMediaType().toString();
   //handle upload
}