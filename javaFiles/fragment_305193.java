import static org.junit.Assert.*;

import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;


public class TestJerseyRedirect {

    @Test
    public void test() {
        ClientConfig config = new DefaultClientConfig();
        config.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
        com.sun.jersey.api.client.Client client = Client.create(config);
        client.setFollowRedirects(true);

        LoggingFilter logging = new LoggingFilter(Logger.getAnonymousLogger());


        WebResource service = client.resource(UriBuilder.fromUri("http://mail.google.com").build());
        service.addFilter(logging);
        try {
            String output = service.path("mail")
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

            System.out.println(output);

        } catch (UniformInterfaceException e) {

            if (e.getResponse().getStatus() == 302) {
                String location = e.getResponse().getHeaders().getFirst("Location");

                WebResource service2 = client.resource(UriBuilder.fromUri(location).build());
                service2.addFilter(logging);
                String output2 = service2
                        .accept(MediaType.TEXT_HTML)
                        .get(String.class);

                    System.out.println(output2);

            }
            else {
                e.printStackTrace();
                throw e;
            }
        }

    }
}