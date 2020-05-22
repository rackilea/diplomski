public class Main extends Application {

  @Override
  public void start(final Stage stage) {
    Scene scene = new Scene(new Group());

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(browser);

    TextField textField = new TextField();
    textField.setVisible(false);
    textField.setEditable(false);

    webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue == Worker.State.SUCCEEDED) {

        EventListener mouseOverEventListener = new EventListener() {
          @Override
          public void handleEvent(Event ev) {
            String href = ((Element) ev.getTarget()).getAttribute("href");
            textField.setText(href);
            textField.setVisible(true);
            textField.setPrefWidth(textField.getText().length() * 6); //
            System.out.println(href);
          }
        };

        EventListener mouseOutEventListener = new EventListener() {
          @Override
          public void handleEvent(Event ev) {
            textField.setVisible(false);
          }
        };

        Document document = webEngine.getDocument();
        NodeList nodeList = document.getElementsByTagName("a");
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
          ((EventTarget) nodeList.item(i)).addEventListener("mouseover",mouseOverEventListener,false);
          ((EventTarget) nodeList.item(i)).addEventListener("mouseout",mouseOutEventListener,false);
        }
      }
    });

    String content = "http://java2s.com";
    webEngine.load(content);

    AnchorPane anchorPane = new AnchorPane();
    anchorPane.getChildren().add(scrollPane);
    anchorPane.getChildren().add(textField);
    AnchorPane.setBottomAnchor(textField, 0.0);
    AnchorPane.setLeftAnchor(textField, 0.0);

    scene.setRoot(anchorPane);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}