@Override
public void start(Stage primaryStage) throws Exception {
    StackPane pane = new StackPane();

    IntegerProperty controlled = new SimpleIntegerProperty(); // I don't want to change this.

    final Spinner<Integer> spinner = new Spinner<>(0, 10, 5, 1);

    spinner.getValueFactory().valueProperty().bindBidirectional(controlled.asObject());

    pane.getChildren().add(spinner);

    primaryStage.setScene(new Scene(pane, 300, 275));
    primaryStage.show();
}