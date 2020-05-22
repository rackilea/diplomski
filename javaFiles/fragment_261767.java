package de.scrum_master.stackoverflow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.gargoylesoftware.htmlunit.BrowserVersion.CHROME;
import static java.util.logging.Level.OFF;
import static java.util.logging.Logger.getLogger;

public class Application {
  public static void main(String[] args) throws IOException {
    WebClient webClient = createWebClient();
    String originalURL = "http://www.zara.com/qr/1260020210042";
    String redirectedURL = webClient.getPage(originalURL).getUrl().toString();
    Response response = Jsoup.connect(redirectedURL).execute();
    System.out.println(response.url());
  }

  private static WebClient createWebClient() throws MalformedURLException {
    getLogger("com.gargoylesoftware").setLevel(OFF);
    WebClient webClient = new WebClient(CHROME);
    WebClientOptions options = webClient.getOptions();
    options.setJavaScriptEnabled(true);
    options.setRedirectEnabled(true);
    // IMPORTANT: Without the country/language selection cookie the redirection does not work!
    webClient.addCookie("storepath=us/en", new URL("http://www.zara.com/"), null);
    return webClient;
  }
}