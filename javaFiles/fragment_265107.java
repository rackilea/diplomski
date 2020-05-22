public class WikipediaURLFactory {

    private static final String WIKIPEDIA_BASE_URL = "https://en.wikipedia.org/wiki/";

    public static String createWikiURLString(String search) {
        return WIKIPEDIA_BASE_URL + search;
    }

    public static URL createWikiURL(String search) throws MalformedURLException {
        return new URL(createWikiURLString(search));
    }

    public static Status accessPage (URL url) throws IOException {
        Status status = new Status();
        status.setUrl(url);
        status.setExists(true);

        if (getResponseCode(url) == 404) {
            status.setExists(false);
        }

        return status; 
    }

    private static int getResponseCode (URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        return connection.getResponseCode();
    }
}