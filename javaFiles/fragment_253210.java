@Path("Reports")
public class ReportService {

    @GET
    @Path("/getreport/{parameters}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getReport(@PathParam("parameters") String parameters) throws KettleXMLException, KettleMissingPluginsException, JSONException, UnknownParamException {
        JSONArray jsonarr;
        return Response.status(200).entity("ok").build();
    }


    @GET
    @Path("/start")
    @Produces(MediaType.TEXT_PLAIN)
    public Response startEngine() {
        return Response.status(200).entity("ok").build();
    }
}