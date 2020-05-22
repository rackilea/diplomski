@POST
@Path("/create")
public void create(@FormParam("param1") String param1,
                   @FormParam("param2") String param2) {
    ...
}