static File WEB_ROOT = null;
static {
    try {
        WEB_ROOT = new File(HttpServer.class.getResource("www").toURI());
    } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}