// I used Apache HttpClient.
// For URL, you need to find end point URL.
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

// Input parameter
String username = "";
String password = "";
String url = "";

// Variables 
int responseCode = 0;
String errorMessage = "";
String responseContent = "";
String content = ""

HttpResponse response;

try
{
    content = 
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:log=\"LogsGet\" xmlns:mal=\"MalteseGlobal\" xmlns:job=\"JobGlobal\">" + 
        "\n  <soapenv:Body>" +
        "\n    <log:LogsGetReq Cmd=\"Start\" OpV=\"01.00.00\" Sev=\"Info to critical\"/>" + 
        "\n  </soapenv:Body>" +
        "\n</soapenv:Envelope>";

    // Create the POST object and add the parameters
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader("Content-Type", "text/xml; charset=utf-8");

    // Enable preemptive authentication within HttpClient so that HttpClient will 
    // send the basic authentications reponse before the server gives an unauthorized reponse. 
    String host = httpPost.getURI().getHost();
    int port = httpPost.getURI().getPort();   
    AuthScope authScope = new AuthScope(host, port);
    DefaultHttpClient httpClient = new DefaultHttpClient();
    UsernamePasswordCredentials credentials = new     UsernamePasswordCredentials(username, password);
    httpClient.getCredentialsProvider().setCredentials(authScope, credentials);   

    StringEntity input = new StringEntity(content);
    input.setContentType("application/json");
    httpPost.setEntity(input);   
    response = httpClient.execute(httpPost);

    if (response != null && response.getStatusLine() != null)
    {
        responseCode = response.getStatusLine().getStatusCode();
        responseContent = EntityUtils.toString(response.getEntity());
    }

    System.out.println("\n\n-----------------------------");
    System.out.println("\nResponse code: " + responseCode);
    System.out.println("\nResponse content: " + responseContent);
}
catch (Exception e)
{
    errorMessage  += "\nUnexpected Exception: " + e.getMessage();
    StringWriter sWriter = new StringWriter();
    PrintWriter pWriter = new PrintWriter(sWriter, true);
    e.printStackTrace(pWriter);
    errorMessage += "\n" + sWriter.getBuffer().toString();

    errorMessage += "\n------------Error Detail------------";
    errorMessage += "\n" + e;
    errorMessage += "\n" + e.getMessage();
    errorMessage += "\n" + e.getLocalizedMessage();
    errorMessage += "\n" + e.getCause();
    errorMessage += "\n" + Arrays.toString(e.getStackTrace());
    errorMessage += "\n" + e.printStackTrace();
    errorMessage += "\n------------------------------------";
}
finally
{
    if(response)
    {
        EntityUtils.consume(response.getEntity());    
    }
}

if(errorMessage != "")
{
    System.out.println("Error: " + errorMessage);
}