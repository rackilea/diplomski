Dictionary cache = (Dictionary) pane.getDocument().getProperty("imageCache");

if (cache == null) {

    cache = new ImageCache();
    pane.getDocument().putProperty("imageCache", cache);
}