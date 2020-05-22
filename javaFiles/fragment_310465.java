@POST
@Path("/create")
public void create(@HeaderParam("param1") String param1,
                   @HeaderParam("param2") String param2) {
    ...
}