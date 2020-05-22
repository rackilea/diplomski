public class PingResource {

    @Context ServletContext context;

    public String myServiceMethod() {
       context.getInitParam("ContextParam");
    }

}