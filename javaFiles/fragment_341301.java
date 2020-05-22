@FXML
private WebView webview ;

@FXML
private WebEngine webengine ;

public void initialize() {
    this.webengine.load("http://www.oracle.com/us/products/index.html");
}