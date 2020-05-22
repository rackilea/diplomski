@Path("myresource")
public class MyResource {

    @PUT
    @Path("/reduceEnergy/{id}/{action}")
    public String reduceEnergyConsumption(@PathParam("id") int id, 
                                          @PathParam("action") String action) {
        System.out.println("id: " + id);
        System.out.println("action: " + action);
        return "";
    }
}