import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


class WrappedUrl {
    private URL obj;

    WrappedUrl(String url) {
        try {
            obj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    URLConnection openConnection() {
        URLConnection connection = null;
        try {
            connection = obj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}