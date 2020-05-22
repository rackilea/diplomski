@Path("/uploadPhoto")
@ApiOperation(
        value = "Upload a photo for an Ad",
        response = Response.class)
@POST
@Timed
@UnitOfWork
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public Response uploadFile(FormDataMultiPart multiPart) {


    List<AdImage> images = new ArrayList<AdImage>();
    List<FormDataBodyPart> bodyParts =
            multiPart.getFields("file");
    for (FormDataBodyPart part : bodyParts) {
        images.add(writeImageAndSave(part.getValueAs(InputStream.class
        ), part.getFormDataContentDisposition()));
    }

    return Response.ok(toJson(images), MediaType.APPLICATION_JSON).build();
}