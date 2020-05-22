@GET
@Path("task/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Task getTasks(@PathParam("id") String id) throws JSONException{
    return task(id);
}