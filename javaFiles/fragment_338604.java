@Path("/hello")
public class FormResource
{
    //@GET
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public MyHashMapObject<String, String> post(
                MyHashMapObject<String, String> anotherMap) {

        anotherMap.getMapProperty().put("e", "10");
        anotherMap.getMapProperty().put("f", "11");
        anotherMap.getMapProperty().put("g", "12");

        return anotherMap;
    }
}