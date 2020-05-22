@Path("/item")
public class ItemResource {
    @Path("content")
    public ItemContentResource getItemContentResource() {
        return new ItemContentResource();
    }
}

public class ItemContentResource {
    @PUT
    @Path("{version}")
    public void put(@PathParam("version") int version)
    }
}