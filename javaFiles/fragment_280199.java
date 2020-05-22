import java.net.URL;
import java.io.InputStream;

public class Demo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.eancdn.com/ean-services/rs/hotel/v3/list?apiKey=vkndmgahz5aekd65pxg4rvvp&locale=en_US&currencyCode=USD&latitude=51.514&longitude=-0.269");
        InputStream is = url.openStream();

        int next = is.read();
        while(next != -1) {
            System.out.print((char) next);
            next = is.read();
        }
    }

}