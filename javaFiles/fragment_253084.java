@Path("ints")
public class TestResource {

 @GET
 @Produces("application/xml")
 public Response get() {
  int[] ints = {1, 2, 3};
  IntArray intArray = new IntArray(ints);
  return Response.ok(intArray).build();
 } 
}