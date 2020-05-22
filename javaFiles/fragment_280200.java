import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class Demo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.eancdn.com/ean-services/rs/hotel/v3/list?apiKey=vkndmgahz5aekd65pxg4rvvp&locale=en_US&currencyCode=USD&latitude=51.514&longitude=-0.269");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        InputStream is = connection.getInputStream();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(is);
    }

}