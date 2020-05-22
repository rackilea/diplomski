@POST
@Path("/create/{param1}/{param2}")
public void create(@PathParam("param1") String param1,
                   @PathParam("param2") String param2) {
    ...
}