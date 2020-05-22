public class FormBean {
    @FormParam("foo")
    private String foo;
    @FormParam("bar")
    private String bar;
    // getters and setters
}

@POST
@Consumes("application/x-www-form-urlencoded")
public Response post(@BeanParam FormBean form) {
}