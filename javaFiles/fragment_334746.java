@Override
public void start(Stage stage) {
    WebView webView = new WebView();
    WebEngine engine = webView.getEngine();
    engine.loadContent("<html>"
            + "<body></body>"
            + "</html>");
    TextField textField = new TextField();
    Button button = new Button("add");
    button.setOnAction(evt -> {
        String text = textField.getText();
        Document doc = engine.getDocument();
        Element element = (Element) doc.getElementsByTagName("body").item(0);
        element.appendChild(doc.createTextNode(text));
    });

    Scene scene = new Scene(new VBox(webView, textField, button));

    stage.setScene(scene);
    stage.show();
}