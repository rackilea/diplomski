@Inject
private SomeBean someBean;

@GET
public Response someMethod() {
    return Response.ok(someBean.getFoo()).build();
}