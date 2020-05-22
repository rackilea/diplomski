class PayLoad {
    private String id;
    private String todo;
    // Getter and Setters
}

@Path("/service")
public class Rest extends Application{
    @POST
    @Path("/create")
        public Response printMessage(@RequestBody PayLoad payload) {
            JSONObject result = new JSONObject();

            result.put("id", payload.getId());
            result.put("todo", payload.getTodo());

            return Response.status(200).entity(result.toString()).build();
        }
}