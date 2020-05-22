import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HTTP;


public class DownloadAuthenticatedFile{

    public static void main(String... args){

        try{
            DefaultHttpClient httpclient = new DefaultHttpClient();

            HttpGet httpget = new HttpGet("http://website.com");

            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            System.out.println("Login form get: " + response.getStatusLine());
            if (entity != null) {
                entity.consumeContent();            
            }
            System.out.println("Initial set of cookies:");
            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }

            HttpPost httpost = new HttpPost("http://www.somewebsite.com/MemberSingIn");

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("email", "USERNAME"));
            nvps.add(new BasicNameValuePair("password", "PASSWORD"));
            nvps.add(new BasicNameValuePair("remember", "true"));

            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            response = httpclient.execute(httpost);
            entity = response.getEntity();

            System.out.println("Login form get: " + response.getStatusLine());
            if (entity != null) {
                entity.consumeContent();
            }

            System.out.println("Post logon cookies:");
            cookies = httpclient.getCookieStore().getCookies();
            String mySessionId = null;
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    if(cookies.get(i).toString().contains("SessionId=")){
                        int index1 = cookies.get(i).toString().indexOf("SessionId");
                        String temp = cookies.get(i).toString().substring(index1);
                        int index2 = temp.toString().indexOf("]");
                        temp = cookies.get(i).toString().substring(index1+10,index1+index2);
                        mySessionId = temp;
                    }
                    System.out.println("- " + cookies.get(i).toString());
                }
            } 

            httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
            httpget = new HttpGet("http://PATHOFWEBSITETOFILE");
            response = httpclient.execute(httpget);
            entity = response.getEntity();
            Header[] headers = response.getAllHeaders();
            for(int i=0;i<headers.length;i++){
                System.out.println("Header: "+headers[i].toString());
            }
            System.out.println(response.toString());

            System.out.println("File get: " + response.getStatusLine());

            InputStream in = entity.getContent();
              File path = new File("/home/mrsevensevenseven");
              path.mkdirs();
              File file = new File(path, "myfile.xls");
              FileOutputStream fos = new FileOutputStream(file);

              byte[] buffer = new byte[1024];
              int len1 = 0;
              while ((len1 = in.read(buffer)) != -1) {
                      fos.write(buffer, 0, len1);
              }

              fos.close();

            httpclient.getConnectionManager().shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}