import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

byte[] data = null;
//...assign protobuf binary buffer to data...

HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("http://127.0.0.1");
HttpEntity entity = new ByteArrayEntity(data);
post.setEntity(entity);
post.setHeader(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
HttpResponse response=null;
try {
    response = client.execute(post);
} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

ResponseCode = response.getStatusLine().getStatusCode().toString();
//if some assert is true then
Issuccess = true;
ResponseMessage="Some Response Message";