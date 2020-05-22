@ApplicationPath("rest")
public class MyApplication extends javax.ws.rs.core.Application {
}

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public String sayHelloWorld() {
        return "Hello World!";
    }
}