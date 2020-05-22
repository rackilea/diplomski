@FXML
private Text text;

public MyControlSkin(MyControl control) throws IOException {
    super(control);
    getChildren().clear();

    FXMLLoader loader = new FXMLLoader(someUrl);
    loader.setRoot(this);
    loader.setController(this);
    loader.load();

    text.textProperty().bind(control.textProperty());
}