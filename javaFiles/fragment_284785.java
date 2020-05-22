@POST
@Path("makesomething")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.TEXT_PLAIN)
public String makesomething(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail, @FormDataParam("variable") String variable, @Context HttpServletRequest request) throws IOException {
    makeSomethingImpl(uploadedInputStream, fileDetail, variable, request);
}

@POST
@Path("makesomething")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String makesomething(@FormDataParam("variable") String variable, @Context HttpServletRequest request) throws IOException {
    makeSomethingImpl(null, null, variable, request);
}

private String makeSomethingImpl(final InputStream uploadedInputStream, final FormDataContentDisposition fileDetail, final String variable, final HttpServletRequest request) {
    // make something
}