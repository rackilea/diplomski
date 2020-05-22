@Path("chickens")
public class ChickensResource {

    @Inject
    ChickenService cs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chicken> chickens() {
        return cs.getAllChickens();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void save(JsonObject chicken) {
        String name = chicken.getString("name");
        int age = chicken.getInt("age");
        cs.save(new Chicken(name, age));
    }
}