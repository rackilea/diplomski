import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class IndependenceMedical {

    private Map<String, String> loginCookies;

    public IndependenceMedical() {
        login();
    }

    private void login() {
        try {
            Connection.Response res = Jsoup.connect("https://www.indemed.com/Action/Login/LoginAction.cfm?refer=MyAccount&qs=")
                    .data("UserName",       "myUserName")
                    .data("Password",       "myPassword")
                    .data("AccountNumber",  "myAccountNumber")
                    .method(Method.POST)
                    .execute();

            loginCookies = res.cookies();
        } catch (MalformedURLException ex) {
            System.out.println("The URL specified was unable to be parsed or uses an invalid protocol. Please try again.");
            System.exit(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\nAn exception occurred.");
            System.exit(1);
        }
    }

    public Document getDoc(String itemNumber){
        try {
            return Jsoup.connect("https://www.indemed.com/Catalog/SearchResults.cfm?source=advancedSearch&psku=" + itemNumber + "&keyword=&PHCPCS=&PClassID=&ManufacturerID=&Search.x=41&Search.y=9")
                        .cookies(loginCookies)
                        .get();

        } catch (IOException e) {}

        return null;
    }

    public String getPrice(Document doc){
        try {
            Elements stuff = doc.select("#tr_51187955");
            stuff = stuff.select("div.product-price");
            String newStuff = stuff.toString();
            newStuff = newStuff.substring(newStuff.indexOf("$")); // throws exception because "$" is not in the String.
            newStuff = newStuff.substring(0, newStuff.indexOf(" "));
            return newStuff;
        } catch (Exception arg0) {
            return "";
        }
    }

    public static void main(String[] args){
        IndependenceMedical test = new IndependenceMedical();
        Document doc = test.getDoc("187955");
        System.out.println("\n\n\n\n\n\n\n\n\n\n"); //to separate the return lines
        System.out.println(test.getPrice(doc));
    }
}