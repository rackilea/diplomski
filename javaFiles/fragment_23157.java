@POST
@Path('my/url')
public Response myPost(Map<String, Object> map) {
    boolean valueDefined = map.containsKey("value");
    ...
}