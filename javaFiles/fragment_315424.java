import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import junit.framework.Assert;
import org.junit.Test;

public class SimpleTest extends JerseyTest {

    @Path("service")
    public static class Service {
        @GET
        public String getTest() { return "Hello World!"; }
    }

    public static class AppConfig extends DefaultResourceConfig {
        public AppConfig() {
            super(Service.class);
        }
    }

    @Override
    public WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .initParam(WebComponent.RESOURCE_CONFIG_CLASS, 
                           AppConfig.class.getName())
                .build();
    }

    @Test
    public void doTest() {
        WebResource resource = resource().path("service");
        String result = resource.get(String.class);
        Assert.assertEquals("Hello World!", result);
        System.out.println(result);
    }
}