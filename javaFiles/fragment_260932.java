@POST
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public String post(@Context ContainerRequest request) {
    final String contentLength = request.getHeaderString(HttpHeaders.CONTENT_LENGTH);
    if (contentLength != null && Integer.parseInt(contentLength) != 0) {
        FormDataMultiPart multiPart = request.readEntity(FormDataMultiPart.class);
        FormDataBodyPart part = multiPart.getField("test");
        String result = part.getValueAs(String.class);
        return result;
    }
    return "no body";
}