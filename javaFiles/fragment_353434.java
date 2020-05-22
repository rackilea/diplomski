import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class JsonMapTest {

    @XmlRootElement
    public static class PartnerEntityDTO {
        @XmlElement String name;

        public PartnerEntityDTO(){}
        public PartnerEntityDTO(String name){ this.name = name;  }
    }

    @Path("/")
    public interface Service {
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/getpartners")
        public Map<String, PartnerEntityDTO> getPartners() throws NamingException;
    }

    public static class ServiceImpl implements Service{

        public Map<String, PartnerEntityDTO> getPartners() throws NamingException {
            Map<String, PartnerEntityDTO> map = new HashMap<String, PartnerEntityDTO>();

            map.put("1", new PartnerEntityDTO("one"));

            return map;
        }
    }

    static final TJWSEmbeddedJaxrsServer server = new TJWSEmbeddedJaxrsServer();

    @BeforeClass
    public static void start(){
        server.setPort(8080);
        server.start();
    }

    @AfterClass
    public static void stop(){
        server.stop();
    }

    @Test
    public void test2() throws Exception {
        server.getDeployment().getRegistry().addSingletonResource(new ServiceImpl());
        String url = "http://localhost:8080";
        Service service = ProxyFactory.create(Service.class, url);
        Map<String, PartnerEntityDTO> partners = service.getPartners();

        assertEquals(1, partners.size());
        assertEquals("1", partners.keySet().iterator().next());
        assertEquals("one", partners.values().iterator().next().name);

    }

    @Test
    public void test() throws Exception {
        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addSingletonResource(new ServiceImpl());

        MockHttpRequest request = MockHttpRequest.get("/getpartners");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);

        assertEquals("{\"1\":{\"partnerEntityDTO\":{\"name\":\"one\"}}}", response.getContentAsString());
    }
}