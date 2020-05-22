@Path("/ftocservice")
public class RestService {


  @GET
  @Produces("application/json")
  public Response convertFtoCfromInput(@QueryParam("f") float f)
        throws Exception {

    DbCon db = new DbCon();
    ArrayList<Student> students = db.getStudentList();
    JSONArray jsonArray = new JSONArray(students);

    String result = jsonArray.toString();

    return Response.status(200).entity(result).build();
  }
}