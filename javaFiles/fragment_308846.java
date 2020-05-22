@GET
@Path("/getLocale")
@Produces({ MediaType.APPLICATION_JSON} )
public Response getLocale(@Context HttpServletRequest request) {
    ResponseBuilder responseBuilder = Response.status(200);

    String str=null;
    byte[] bytes=null;

    String appLocation = SystemParameters.getInstance().getParameter("application.home.dir")+"/WEB-INF/lang/";

    InputStream is = new FileInputStream(appLocation+"/en_US.json");

    try {
        bytes = IOUtils.toByteArray(is);
    } catch (IOException e) {
        //ERROR
    }

    str = new String(bytes, "UTF-8");
    str = str.replaceAll("\\r\\n", "");
    str = str.replaceAll("\\t", "");
    str = str.replaceAll("\\\"", "\"");

    return responseBuilder.entity(str).build();
}