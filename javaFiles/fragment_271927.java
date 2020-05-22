import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.junit.Test;
import static junit.framework.Assert.*;

public class HtmlParserTest extends JerseyTest {

    @Path("login")
    public static class LoginController {

        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.TEXT_HTML)
        public String doLogin(MultivaluedMap<String, String> formParams) {
            boolean valid = false;
            valid = "user".equals(formParams.getFirst("username"));
            valid = "pass".equals(formParams.getFirst("password"));

            String message = valid ? "You Win!" : "You Lose!";
            String html
                    = "<html>\n"
                    + "    <body>\n"
                    + "        <h1 id=\"message\">" + message + "</h1>\n"
                    + "    </bod;y>\n"
                    + "</html>";
            return html;
        }
    }

    @Override
    public Application configure() {
        return new ResourceConfig(LoginController.class);
    }

    @Test
    public void youWinMessageWithValidCredentials() {
        String message = handleRequest("pass");
        assertEquals("You Win!", message);
    }

    @Test
    public void youLoseMessageWithBadCredentials() {
        String message = handleRequest("wrong");
        assertEquals("You Lose!", message);
    }

    private String handleRequest(String password) {
        Form form = new Form();
        form.param("username", "user");
        form.param("password", password);
        String html = target("login").request()
                .accept(MediaType.TEXT_HTML)
                .post(Entity.form(form), String.class);
        return getMessageContent(html);
    }

    /* jsoup code */
    private String getMessageContent(String html) {
        Document document = Jsoup.parse(html);
        Element messageElem = document.getElementById("message");
        return messageElem.text();
    }
}