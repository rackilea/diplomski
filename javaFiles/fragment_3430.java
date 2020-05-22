@Path("/")
@JsonView(View.Partial.class)
public Collection<Car> getAll();

@Path("/{id}")
@JsonView(View.Full.class)
public Car getById(@PathParam("id") int id);