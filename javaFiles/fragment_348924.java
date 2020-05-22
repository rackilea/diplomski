@Path("/tasks")
public class TasksService{

@GET
@Produces(MediaType.APPLICATION_JSON)
public ArrayList<Task> getTask() throws JSONException{
    return tasks;
}

@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTasks(@PathParam("id") String id) throws JSONException{
        return task(id);
    }
}