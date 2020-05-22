import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public static void sendSimpleMessage(String recipient) {
        Client clientMail = ClientBuilder.newBuilder().build();
              clientMail.register(HttpAuthenticationFeature.basic("api", MAILGUN_API_KEY));

        WebTarget targetMail = clientMail.target("https://api.mailgun.net/v3/" + MAILGUN_DOMAIN_NAME + "/messages");

        Form formData = new Form();
              formData.param("from", "Mailgun Sandbox <"+DOMAIN_MAIL_ADDRESS+">");
              formData.param("to", recipient);
              formData.param("subject", "Simple Mailgun Example");
              formData.param("text", "Plaintext content");

        Response response = targetMail.request().post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        System.out.println("Mail sent : " + response);

    }