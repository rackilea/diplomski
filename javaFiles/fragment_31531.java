import org.apache.commons.httpclient.HttpClient;
 import org.apache.commons.httpclient.HttpException;
 import org.apache.commons.httpclient.HttpStatus;
 import org.apache.commons.httpclient.methods.PostMethod;
 import org.apache.http.impl.client.HttpClients;

public class PostReqEx {

  public void sendReq(String url,String email,String fname){
    HttpClient httpClient = HttpClients.createDefault();
    PostMethod postMethod = new PostMethod(url);
    postMethod.addParameter("Email", email);
    postMethod.addParameter("fname", fname);
    try {
        httpClient.executeMethod(postMethod);
    } catch (HttpException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
        String resp = postMethod.getResponseBodyAsString();
    } else {
         //...postMethod.getStatusLine();
    }
  }
}