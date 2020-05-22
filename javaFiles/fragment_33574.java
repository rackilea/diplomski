import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlReaderTest {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.classpath"));
    try {
      Document doc = Jsoup.connect("https://www.amazon.com").get();
      System.out.print(doc.text());
    }
    catch (IOException e) {
      System.err.println("Error");
    }

  }
}