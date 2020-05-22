@POST
@Path("/create")
public void create(@QueryParam("param1") String param1,
                   @QueryParam("param2") String param2) {
    ...
}