@FXML
private WebView webview ;

private WebEngine webengine ;

public void initialize() {
    this.webengine = this.webview.getEngine();
    this.webengine.load("http://www.oracle.com/us/products/index.html");
}