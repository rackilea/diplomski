@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {}

@Path("/animals")
public class AnimalsResource {

    @GET
    public List<Animal> getAll() {}

    @Path("/{id}")
    pubic Animal getOne(@PathParam("id") int id) {}
}