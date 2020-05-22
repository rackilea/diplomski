import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.xml.JacksonJaxbXMLProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

public class FullCxfJaxrsJacksonExample {
    public static void main(String[] args) {
        String serverAddress = "http://localhost:9000/";
        Server server = null;

        try {
            // make server that supports JSON and XML
            JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
            serverFactory.setResourceClasses(ShapeServiceRandom.class);
            serverFactory.setAddress(serverAddress);
            serverFactory.setProviders(Arrays.asList(new JacksonJaxbJsonProvider(), new JacksonJaxbXMLProvider()));
            server = serverFactory.create();

            // make and use a client
            JAXRSClientFactoryBean clientFactory = new JAXRSClientFactoryBean();
            clientFactory.setAddress(serverAddress);
            clientFactory.setServiceClass(ShapeService.class);
            clientFactory.setProvider(new JacksonJaxbJsonProvider());
            clientFactory.setHeaders(Collections.singletonMap("Accept", "application/json"));
            // for an XML client instead of a JSON client, use the following provider/headers instead:
            //clientFactory.setProvider(new JacksonJaxbXMLProvider());
            //clientFactory.setHeaders(Collections.singletonMap("Accept", "application/xml"));

            ShapeService shapeServiceClient = clientFactory.create(ShapeService.class);
            for (int i = 0; i < 10; i++) {
                System.out.format("created shape: %s\n", shapeServiceClient.create());
            }

        } finally {
            if (server != null) {
                server.destroy();
            }
        }
        System.exit(0);
    }

    // Put JsonTypeInfo on the abstract base class so class info gets marshalled.
    // You'll want CLASS instead of MINIMAL_CLASS if your base class and subclasses are in different packages.
    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY)
    public abstract static class Shape {
    }

    public static class Circle extends Shape {
        public double radius;

        @Override
        public String toString() {
            return "Circle{radius=" + radius + '}';
        }
    }

    public static class Polygon extends Shape {
        public int numSides;

        @Override
        public String toString() {
            return "Polygon{numSides=" + numSides + '}';
        }
    }

    // service definition with abstract return type
    @Path("/shape")
    public interface ShapeService {
        @GET
        @Path("/create")
        @Produces({APPLICATION_JSON, APPLICATION_XML})
        Shape create();
    }

    // service implementation that returns different concrete subclasses
    public static class ShapeServiceRandom implements ShapeService {
        Random random = new Random();

        public Shape create() {
            int num = random.nextInt(8);
            if (num > 3) {
                Polygon polygon = new Polygon();
                polygon.numSides = num;
                return polygon;
            } else {
                Circle circle = new Circle();
                circle.radius = num + 0.5;
                return circle;
            }
        }
    }
}