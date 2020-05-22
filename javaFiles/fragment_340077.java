import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TokenAuth{
  private static final String TOKEN_ID="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
  private static final String TOKEN_SECRET="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
  private static final String CONSUMER_KEY="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
  private static final String CONSUMER_SECRET="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
  private static final String REALM="123456";
  private static final String CONTENT_TYPE="content-type";
  private static final String APP_JSON="application/json";

  private static final String REST_URL="https://rest.sandbox.netsuite.com/app/site/hosting/restlet.nl?script=xxx&deploy=x";
  private static final String JSON_PAYLOD="{}";

  private static OAuthService service=getService();
  private static Token accessToken=getToken();
  public static void main(String[]args){
    Response responseGet=callWithHttpGet();
    System.out.println(responseGet.getBody());  
    Response responsePost=callWithHttpPost();
    System.out.println(responsePost.getBody());
  }
  private static Response callWithHttpGet(){
    OAuthRequest request=new OAuthRequest(Verb.GET,REST_URL);
    request.setRealm(REALM);
    service.signRequest(accessToken,request);
    return request.send();
  }
  private static Response callWithHttpPost(){
    OAuthRequest request=new OAuthRequest(Verb.POST,REST_URL);
    request.setRealm(REALM);
    request.addHeader(CONTENT_TYPE,APP_JSON);
    request.addPayload(JSON_PAYLOD);
    service.signRequest(accessToken,request);
    return request.send();
  }
  private static Token getToken(){
    return new Token(TOKEN_ID, TOKEN_SECRET);
  }
  private static OAuthService getService(){
    return new ServiceBuilder().provider(DummyService.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).signatureType(SignatureType.Header).build();
  }
}