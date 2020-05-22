@Override
public void start(Stage primaryStage) {
    Rectangle rect = new Rectangle(100, 100);

    StringConverter<Double> converter = new DoubleStringConverter();

    TextField xTextField = new TextField();
    TextFormatter<Double> xFromatter = new TextFormatter<>(converter);
    xTextField.setTextFormatter(xFromatter);

    TextField widthTextField = new TextField();

    TextFormatter<Double> widthFromatter = new TextFormatter<Double>(converter);
    widthTextField.setTextFormatter(widthFromatter);

    xFromatter.valueProperty().bindBidirectional(rect.xProperty().asObject());
    widthFromatter.valueProperty().bindBidirectional(rect.widthProperty().asObject());

    Scene scene = new Scene(new VBox(10, xTextField, widthTextField, new Pane(rect)), 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}