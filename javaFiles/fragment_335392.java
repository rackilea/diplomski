import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Beside Jersey dependencies, you will need Mockito.
 * 
 *  <dependency>
 *      <groupId>org.mockito</groupId>
 *      <artifactId>mockito-core</artifactId>
 *      <version>1.10.19</version>
 *  </dependency>
 * 
 * @author Paul Samsotha
 */
public class SomethingResourceUnitTest {

    public static interface SomeService {
        String getSomethingById(int id);
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

    private SomethingResource resource;
    private SomeService service;

    @Before
    public void setUp() {
        service = Mockito.mock(SomeService.class);
        resource = new SomethingResource(service);
    }

    @Test
    public void testGetSomethingById() {
        Mockito.when(service.getSomethingById(Mockito.anyInt())).thenReturn("Something");

        Response response = resource.getSomethingById(1);
        assertThat(response.getStatus(), is(200));
        assertThat(response.getEntity(), instanceOf(String.class));
        assertThat((String)response.getEntity(), is("Something"));
    }
}