import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


final WebClient webClient = new WebClient();
HtmlPage page1 = webClient.getPage(URLEvent + eventFBId);
final HtmlForm form = page1.getForms().get(0);
webClient.setJavaScriptTimeout(45000);

final HtmlTextInput textField = form.getInputByName("email");
textField.setValueAttribute(login);
final HtmlPasswordInput textField2 = form.getInputByName("pass");
textField2.setValueAttribute(password);
page1 = (HtmlPage) form.getInputByValue("Log In").click();

URL url = new URL(URLEvent + eventFBId);
Set<Cookie> set = webClient.getCookies(url);

Map<String, String> mapFromSet = new HashMap<String, String>();
   for (Cookie entry : set) {
       mapFromSet.put(entry.getName(), entry.getValue());
   }

Map<String, String> cookies = mapFromSet;
    for (Map.Entry<String, String> entry : cookies.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }

Document doc = Jsoup.connect(URLEvent + eventFBId)
                    .userAgent(useragent)
                    .timeout(200000)
                    .data("email", login)           
                    .data("pass", password)
                    .cookies(cookies).get();

System.out.println(doc);