@POST
@Consumes("application/x-www-form-urlencoded")
public Response post(Form form) {
    MultivaluedMap<String, String> formParams = form.asMap();
    String foo = formParams.getFirst("foo");
}