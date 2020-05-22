private static final String FILE_PATH = "d:\\Test2.zip";
@GET
@Path("/get")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response getFile() {
    File file = new File(FILE_PATH);
    ResponseBuilder response = Response.ok((Object) file);
    response.header("Content-Disposition", "attachment; filename=newfile.zip");
    return response.build();

}