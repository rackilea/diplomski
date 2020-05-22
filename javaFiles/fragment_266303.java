import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

def site = context.expand( '${#Project#Site}' )
def zapiAccessKey = context.expand( '${#Project#zapiAccessKey}' )
def secretID = context.expand( '${#Project#secretID}' )
def user = context.expand( '${#Project#user}' )

    // Replace Zephyr BaseUrl with the <ZAPI_CLOUD_URL> shared with ZAPI Cloud Installation
    String zephyrBaseUrl = site;
    // zephyr accessKey , we can get from Addons >> zapi section
    String accessKey = zapiAccessKey;
    // zephyr secretKey , we can get from Addons >> zapi section
    String secretKey = secretID;
    // Jira UserName
    String userName = user;

    ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName).build();
    JwtGenerator jwtGenerator = client.getJwtGenerator();

    // API to which the JWT token has to be generated
    String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/cycle";

    URI uri = new URI(createCycleUri);

    int expirationInSec = 3600;
    String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);

  log.info "JWT Token : " + jwt

  //Store token in property.
  context.testCase.testSuite.project.setPropertyValue('JWT_Token', jwt)