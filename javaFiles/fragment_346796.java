public final class Network {
    public interface UrlOpener {
        public InputStream open(URL url) throws IOException;
    }

    private static UrlOpener urlOpener = new UrlOpener() {
        public InputStream open(URL url) throws IOException {
            return url.openStream();
        }
    };

    public static InputStream openUrl(URL url) throws IOException {
        return urlOpener.open(url);
    }

    public static void setUrlOpener(UrlOpener urlOpener) {
        Network.urlOpener = urlOpener;
    }
}