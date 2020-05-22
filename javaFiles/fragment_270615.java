import java.net.URL;
import java.net.URLConnection;

try {
    final URL url = new URL("file://" + basePath + "/" + fileName);
    final URLConnection urlConnection = url.openConnection();
    return urlConnection.getContentType();
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}