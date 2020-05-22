@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response newUpload(@Context UriInfo uriInfo, FormDataMultiPart multipart,
        @Context HttpServletRequest httpRequest) {
    FormDataBodyPart fileSize = multipart.getField("fileSize");
    long size = Long.valueOf(fileSize.getValue());
    if (!checkSizeLimits(size)) {
        return Response.status(Status.BAD_REQUEST).build();
    }
    // here comes some code which generates an unique id and its URI for the data
    ...
    return Response.status(Status.CREATED).entity(new FileUploadInfo(uri.toString())).build();
}

@POST
@Path("/{fileId}")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(@Context UriInfo uriInfo, FormDataMultiPart multipart,
        @Context HttpServletRequest httpRequest, @PathParam("fileId") String fileId) {
    FormDataBodyPart fileSize = multipart.getField("fileSize");
    FormDataBodyPart file = multipart.getField("file");
    //...
    return Response.status(Status.CREATED).entity(new FileUploadInfo(uri.toString())).build();
 }