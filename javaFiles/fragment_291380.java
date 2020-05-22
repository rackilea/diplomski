private int getPageWidth(WebView webView) {
    String script = "Math.max(" +
            "document.body.scrollWidth, document.body.offsetWidth," +
            "document.documentElement.clientWidth, document.documentElement.scrollWidth," +
            "document.documentElement.offsetWidth );";

    WebEngine engine = webView.getEngine();

    int maxWidth = (int) engine.executeScript(script);
    return maxWidth;
}