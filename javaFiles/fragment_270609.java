import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.URLConnection;

final File file = new File(basePath + "/" + fileName);
try {
    final FileInputStream fileInputStream = new FileInputStream(file);
    final InputStream inputStream = new BufferedInputStream(fileInputStream);

    return URLConnection.guessContentTypeFromStream(inputStream);
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}