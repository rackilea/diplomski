@GET
@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public Item getItem() {
    return new Item();
}