public class WebsiteTab extends Tab {

    final static String DEFAULT_SITE = "https://google.com";

    VBox browserBox;
    WebView webView;

    public WebsiteTab() {
        super("Site One");
        webView = new WebView();
        webView.setPrefHeight(5000);

        textProperty().bind(webView.getEngine().titleProperty()); // bind the properties

        goToSite(DEFAULT_SITE);

        browserBox = new VBox(10,webView);
        VBox.setVgrow(browserBox, Priority.ALWAYS);

        setContent(browserBox);
    }

    public void goToSite(final String site) {
        webView.getEngine().load(site);
    }
}