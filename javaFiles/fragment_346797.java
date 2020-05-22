public class SomeType {
    public void processData(URL url) throws IOException {
        InputStream input = Network.openUrl(url);
        // process the data
    }
}