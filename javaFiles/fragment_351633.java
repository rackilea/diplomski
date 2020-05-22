@SuppressWarnings({ "rawtypes" })
public static void removeImageFromCache(JTextPane pane, String name) throws MalformedURLException {
    Dictionary cache = (Dictionary) pane.getDocument().getProperty("imageCache");
    if (cache == null) {
        // There is no cache, so the image is not in the cache.
        return;
    }
    String url = "http:\\buffered/" + name;
    cache.remove(new URL(url));
}