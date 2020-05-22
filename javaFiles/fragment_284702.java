import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.annotation.Priority;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Run it like any other JUnit test. Only two required dependencies:
 *
 * <dependency>
 *   <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *   <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *   <version>${jersey2.version}</version>
 * </dependency>
 * <dependency>
 *   <groupId>org.glassfish.jersey.media</groupId>
 *   <artifactId>jersey-media-json-jackson</artifactId>
 *   <version>${jersey2.version}</version>
 * </dependency>
 * 
 * @author Paul Samsotha.
 */
public class UriConnegTests extends JerseyTest {

    @XmlRootElement
    public static class Model {
        private String message;
        public Model() {}
        public Model(String message) { this.message = message; }
        public String getMessage() { return this.message; }
        public void setMessage(String message) { this.message = message; }
    }


    @Path("test")
    public static class TestResource {
        @GET
        @Produces({"application/json", "application/xml"})
        public Model get() {
            return new Model("Hello World");
        }
    }

    @Provider
    @PreMatching
    @Priority(3000)
    public static class QueryConnegFilter implements ContainerRequestFilter {

        private static final Map<String, String> mappings;

        static {
            Map<String, String> map = new HashMap<>();
            map.put("xml", MediaType.APPLICATION_XML);
            map.put("json", MediaType.APPLICATION_JSON);
            mappings = Collections.unmodifiableMap(map);
        }

        @Override
        public void filter(ContainerRequestContext request) throws IOException {
            final String format = request.getUriInfo().getQueryParameters().getFirst("format");
            if (format != null) {
                final String mediaType = mappings.get(format);
                if (mediaType != null) {
                    request.getHeaders().putSingle(HttpHeaders.ACCEPT, mediaType);
                }
            }
        }
    }

    @Override
    public ResourceConfig configure() {
        final Map<String, MediaType> mappings = new HashMap<>();
        mappings.put("json", MediaType.APPLICATION_JSON_TYPE);
        mappings.put("xml", MediaType.APPLICATION_XML_TYPE);
        return new ResourceConfig()
                .register(TestResource.class)
                .register(QueryConnegFilter.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true))
                .property(ServerProperties.MEDIA_TYPE_MAPPINGS, mappings);
    }

    @Test
    public void returnsXmlFromExtension() {
        final String expected = "<message>Hello World</message>";
        final String data = target("test.xml")
                .request()
                .get(String.class);
        assertThat(data, containsString(expected));
    }

    @Test
    public void returnsJsonFromExtension() {
        final String expected = "{\"message\":\"Hello World\"}";
        final String data = target("test.json")
                .request()
                .get(String.class);
        assertThat(data, is(expected));
    }

    @Test
    public void returnsXmlFromQuery() {
        final String expected = "<message>Hello World</message>";
        final String data = target("test")
                .queryParam("format", "xml")
                .request()
                .get(String.class);
        assertThat(data, containsString(expected));
    }

    @Test
    public void returnsJsonFromQuery() {
        final String expected = "{\"message\":\"Hello World\"}";
        final String data = target("test")
                .queryParam("format", "json")
                .request()
                .get(String.class);
        assertThat(data, is(expected));
    }
}