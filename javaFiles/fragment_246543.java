public class FileUtils {
    public static URL toURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new InternalError(e);
        }
    }
}