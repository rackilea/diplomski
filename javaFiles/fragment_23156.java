@POST
@Path('my/url')
public Response myPost(Body body) {
    boolean valueDefined = body.isValueDefined();
    ...
}