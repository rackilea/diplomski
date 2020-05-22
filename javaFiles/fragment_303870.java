import java.net.MalformedURLException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.SSLProtocolSocketFactory;



import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class TestHttpClient {
public static String formPostUrl ="https://login.findmespot.com/faces/welcome.jsp" ;
public static String LOGON_SITE = "login.findmespot.com";
static final int    LOGON_PORT = 443;
public static void main(String[] args ) throws MalformedURLException
{
        String nextHref="";
        HttpClient client = new HttpClient();

        HttpMethod authGetmethod = new GetMethod("https://login.findmespot.com/index.jsp");
        authGetmethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.9) Gecko/2009040821 Firefox/3.0.9");
        authGetmethod.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        authGetmethod.setRequestHeader("Accept-Language","en-us,en;q=0.5");
        authGetmethod.setRequestHeader("Accept-Encoding","gzip,deflate");
        authGetmethod.setRequestHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        authGetmethod.setRequestHeader("Keep-Alive","300");
        authGetmethod.setRequestHeader("Connection","keep-alive");

        //authGetmethod.setRequestHeader("Referer","https://login.findmespot.com/faces/welcome.jsp");

    try
    {
        //send first request to capture cookie information
       int status = client.executeMethod(authGetmethod);


      BufferedReader br   = new  BufferedReader(new InputStreamReader(authGetmethod.getResponseBodyAsStream()));

       String str ="";
       String resultJsessionid="";
             while((str=br.readLine())!=null )
               {
                 if(str.indexOf("jsessionid=")!=-1)
                 {
                     //capture Session ID
                     resultJsessionid=getJsessionid(str);
                  break;
                 }
               }

           //release connection for final login request
      authGetmethod.releaseConnection();

           client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

       Cookie[] cookies = client.getState().getCookies();
      for (int i = 0; i < cookies.length; i++) {
        Cookie cookie = cookies[i];
        System.err.println(
          "Cookie: " + cookie.getName() +
          ", Value: " + cookie.getValue() +
          ", IsPersistent?: " + cookie.isPersistent() +
          ", Expiry Date: " + cookie.getExpiryDate() +
          ", Comment: " + cookie.getComment());


        //PostMethod authpost = new PostMethod("https://login.findmespot.com/faces/welcome.jsp?jessionid="+resultJsessionid );
        PostMethod authpost = new PostMethod("https://login.findmespot.com/faces/welcome.jsp");
        // Set Headers
        authpost.setRequestHeader("http.Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.9) Gecko/2009040821 Firefox/3.0.9");
        authpost.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        authpost.setRequestHeader("Accept-Language","en-us,en;q=0.5");
        authpost.setRequestHeader("Accept-Encoding","gzip,deflate");
        authpost.setRequestHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        authpost.setRequestHeader("Keep-Alive","300");
        authpost.setRequestHeader("Connection","keep-alive");
        authpost.setRequestHeader("Referer","https://login.findmespot.com/faces/index.jsp");



        // Prepare login parameters
        NameValuePair inputtext1      = new NameValuePair("inputText1","TANGOFOUR");
        NameValuePair inputtext5   = new NameValuePair("inputText5", "~CcxpqFR");
        NameValuePair oafF = new NameValuePair("oracle.adf.faces.FORM", "form11");
        NameValuePair source      = new NameValuePair("source","commandButton1");
        NameValuePair event   = new NameValuePair("event", "update");
        NameValuePair partialTarget = new NameValuePair("partialTarget", "");
        NameValuePair partial = new NameValuePair("partial", "true");

        authpost.setRequestBody(
          new NameValuePair[] {inputtext1,inputtext5,oafF,source,event,partialTarget,partial});

        client.executeMethod(authpost);
        System.out.println("Login form post: " + authpost.getStatusLine().toString());
        // release any connection resources used by the method


        String readLine;

          br = new BufferedReader(new InputStreamReader(authpost.getResponseBodyAsStream()));
             while(((readLine = br.readLine()) != null)) {
              System.out.println(readLine);
              nextHref=getNexthref(readLine);
          }

          authpost.releaseConnection();


         Cookie[] cookies1 = client.getState().getCookies();
            for (int i1 = 0; i < cookies1.length; i++) {
        Cookie cookie1 = cookies1[i1];
        System.err.println(
          "Cookie: " + cookie1.getName() +
          ", Value: " + cookie1.getValue() +
          ", IsPersistent?: " + cookie1.isPersistent() +
          ", Expiry Date: " + cookie1.getExpiryDate() +
          ", Comment: " + cookie1.getComment());



       HttpMethod authGetmethodNext = new GetMethod("https://login.findmespot.com"+nextHref);
        authGetmethodNext.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.9) Gecko/2009040821 Firefox/3.0.9");
        authGetmethodNext.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        authGetmethodNext.setRequestHeader("Accept-Language","en-us,en;q=0.5");
        authGetmethodNext.setRequestHeader("Accept-Encoding","gzip,deflate");
        authGetmethodNext.setRequestHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        authGetmethodNext.setRequestHeader("Keep-Alive","300");
        authGetmethodNext.setRequestHeader("Connection","keep-alive");
        authGetmethodNext.setRequestHeader("Referer","https://login.findmespot.com/faces/welcome.jsp");


        client.executeMethod(authGetmethodNext);
         System.out.println("Login form post: " + authGetmethodNext.getStatusLine().toString());

        PostMethod authpost1 = new PostMethod("https://login.findmespot.com/faces/history.jsp");
        // Set Headers
        authpost1.setRequestHeader("http.Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.9) Gecko/2009040821 Firefox/3.0.9");
        authpost1.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        authpost1.setRequestHeader("Accept-Language","en-us,en;q=0.5");
        authpost1.setRequestHeader("Accept-Encoding","gzip,deflate");
        authpost1.setRequestHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        authpost1.setRequestHeader("Keep-Alive","300");
        authpost1.setRequestHeader("Connection","keep-alive");
        authpost1.setRequestHeader("Referer","Referer: https://login.findmespot.com/faces/trackerunit.jsp");


               client.executeMethod(authpost1);

           br = new BufferedReader(new InputStreamReader(authpost1.getResponseBodyAsStream()));
             while(((readLine = br.readLine()) != null))
             {
              System.out.println(readLine);
              }

      }
      }
    }
  catch(Exception ex)
   {
        System.out.println(ex.getMessage());
    }


}
public static String getJsessionid(String responseText) /// retu
{

    String jsession="";
    int start_index= responseText.indexOf("jsessionid=");
    if(start_index!=-1)
    {
       jsession= responseText.substring(start_index+11);
    }
    int last_index=jsession.indexOf("\"");
    if(last_index!=-1)
    jsession=jsession.substring(0,last_index);
 return jsession;
}

public static String getNexthref(String inputhref)
{
   String result_href="";
   int start_index=inputhref.indexOf("href='");
     if(start_index!=-1)
   {
       result_href=inputhref.substring(start_index+6);
   }
     int last_index=result_href.indexOf("'");
   if(last_index!=-1)
       result_href=result_href.substring(0,last_index);

   return result_href;


}

}