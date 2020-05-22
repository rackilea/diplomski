import java.io.File;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Aside from the Jersey dependencies, you will need the following
 * Tomcat dependencies.
 * 
 *  <dependency>
 *      <groupId>org.apache.tomcat.embed</groupId>
 *      <artifactId>tomcat-embed-core</artifactId>
 *      <version>8.5.0</version>
 *      <scope>test</scope>
 *  </dependency>
 *  <dependency>
 *      <groupId>org.apache.tomcat.embed</groupId>
 *      <artifactId>tomcat-embed-logging-juli</artifactId>
 *      <version>8.5.0</version>
 *      <scope>test</scope>
 *  </dependency>
 *
 * See also https://dzone.com/articles/embedded-tomcat-minimal
 *      
 * @author Paul Samsotha
 */
public class SomethingResourceTomcatIntegrationTest {

    public static interface SomeService {
        String getSomethingById(int id);
    }

    public static class SomeServiceImpl implements SomeService {
        @Override
        public String getSomethingById(int id) {
            return "Something";
        }
    }

    @Path("something")
    public static class SomethingResource {

        private final SomeService service;

        @Inject
        public SomethingResource(SomeService service) {
            this.service = service;
        }

        @GET
        @Path("{id}")
        public Response getSomethingById(@PathParam("id") int id) {
            String result = service.getSomethingById(id);
            return Response.ok(result).build();
        }
    }

    private Tomcat tomcat;

    @Before
    public void setUp() throws Exception {
        tomcat = new Tomcat();
        tomcat.setPort(8080);

        final Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        final ResourceConfig config = new ResourceConfig(SomethingResource.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(SomeServiceImpl.class).to(SomeService.class);
                    }
                });
        Tomcat.addServlet(ctx, "jersey-test", new ServletContainer(config));
        ctx.addServletMapping("/*", "jersey-test");

        tomcat.start();
    }

    @After
    public void tearDown() throws Exception {
        tomcat.stop();
    }

    @Test
    public void testGetSomethingById() {
        final String baseUri = "http://localhost:8080";
        final Response response = ClientBuilder.newClient()
                .target(baseUri).path("something").path("1")
                .request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("Something"));
    }
}