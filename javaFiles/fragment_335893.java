import static net.oauth.OAuth.HMAC_SHA1;                                                       
import static net.oauth.OAuth.OAUTH_SIGNATURE_METHOD;                                          

import java.net.URL;
import java.util.List;
import java.util.Map; 

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage; 
import net.oauth.ParameterStyle;
import net.oauth.SimpleOAuthValidator;
import net.oauth.client.OAuthClient;  
import net.oauth.client.httpclient4.HttpClient4;


/**
 * Sample application demonstrating how to do 2-Legged OAuth in the Google Data
 * Java Client.  See the comments below to learn about the details.            
 *                                                                             
 */                                                                            
public class GmailAtomFeed2LeggedOauth {                                       

    public static String CONSUMER_KEY = "test-1001.com";
    public static String CONSUMER_SECRET = "zN0ttehR3@lSecr3+";
    public static String SCOPE = "https://mail.google.com/mail/feed/atom";
    public static String RESOURCE_URL = "https://mail.google.com/mail/feed/atom";
    public static String SERVICE_NAME = "mail";                                  
    public static String username = "username";                                  
    public static boolean debug = true;                                          

    public static void main(String[] args) throws Exception {

        // This should be passed in as a parameter
        String user = username + "@" + CONSUMER_KEY;

        OAuthConsumer consumer = new OAuthConsumer(null, CONSUMER_KEY, CONSUMER_SECRET, null);
        OAuthAccessor accessor = new OAuthAccessor(consumer);                                 

        // HMAC uses the access token secret as a factor,
        // and it's a little less compute-intensive than RSA.
        accessor.consumer.setProperty(OAUTH_SIGNATURE_METHOD, HMAC_SHA1);

        // Gmail only supports an atom feed
        URL atomFeedUrl = new URL(SCOPE +"?xoauth_requestor_id=" + user);

        System.out.println("=====================================================");
        System.out.println("Building new request message...");

        OAuthMessage request = accessor.newRequestMessage(OAuthMessage.GET, atomFeedUrl.toString(),null);

        if (debug) {
            List<Map.Entry<String, String>> params = request.getParameters();
            for (Map.Entry<String, String> p : params) {
                System.out.println("'" + p.getKey() + "' =  <" + p.getValue() + ">");
            }
            System.out.println("Validating message...");
            SimpleOAuthValidator validator=new SimpleOAuthValidator();
            validator.validateMessage(request,accessor);
        }

        OAuthClient client = new OAuthClient(new HttpClient4());

        System.out.println("Client invoking request message...");
        System.out.println(" request: " + request);
        OAuthMessage message = client.invoke(request, ParameterStyle.AUTHORIZATION_HEADER);

        System.out.println("=====================================================");
        System.out.println(" message: " + message.readBodyAsString());
        System.out.println("=====================================================");
    }
}