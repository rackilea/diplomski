public class Schema {
    public static ThreadLocal<String> name = new ThreadLocal<>();
}


public class SchemaNameFilter implements ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        if(request.getQueryParameters().containsKey("schema")) {
            Schema.name.set(request.getQueryParameters().get("schema").get(0));
        }
        return request;
    }
}