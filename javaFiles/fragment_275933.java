@Path("/json")
public class JsonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        EditorStoryChapterInput input = new EditorStoryChapterInput();
        Text title = new Text();
        title.setContent("Hello World");
        input.setTitle(title);
        return Response.ok(input).build();
    }
}