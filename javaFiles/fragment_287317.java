import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class DemoService {
    @GET
    @Path("sayHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() { return "Hello, world!"; }
}