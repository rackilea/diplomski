import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpTest {

public static void main(String[] args) throws HttpException, IOException {
    String url = "http://www.whatarecookies.com/cookietest.asp";
    HttpClient client = new HttpClient();
    client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
    HttpMethod method = new GetMethod(url);
    int res = client.executeMethod(method);
    System.out.println("Result: " + res);
    printCookies(client.getState());
    method = new GetMethod(url);
    res = client.executeMethod(method);
    System.out.println("Result: " + res);
    printCookies(client.getState());
}
public static void printCookies(HttpState state){
    System.out.println("Cookies:");
    Cookie[] cookies = state.getCookies();
    for (Cookie cookie : cookies){
        System.out.println("  " + cookie.getName() + ": " + cookie.getValue());
    }               
}   
}