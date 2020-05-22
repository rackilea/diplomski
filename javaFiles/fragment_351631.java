@SuppressWarnings({ "rawtypes", "unchecked" })
public static String saveImageToCache(JTextPane pane, BufferedImage img, String name) throws MalformedURLException {
    Dictionary cache = (Dictionary) pane.getDocument().getProperty("imageCache");
    if (cache == null) {
        // No cache exists, so create a new one.
        cache = new Hashtable();
        pane.getDocument().putProperty("imageCache", cache);
    }
    String url = "http:\\buffered/" + name;
    cache.put(new URL(url), img);
    return url;
}