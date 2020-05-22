@Override
public void start(Stage primaryStage) {
    Text text00 = new Text("text");
    Text text01 = new Text("text");
    Text text02 = new Text("text");
    Text text10 = new Text("text");
    Text text11 = new Text("text");
    Text text12 = new Text("text");
    GridPane gridPane = new GridPane();

    ColumnConstraints cConstraints = new ColumnConstraints();
    cConstraints.setHalignment(HPos.LEFT);
    cConstraints.setHgrow(Priority.ALWAYS);
    gridPane.getColumnConstraints().addAll(cConstraints, cConstraints);
    gridPane.addColumn(0, text00, text01, text02);
    gridPane.addColumn(1, text10, text11, text12);

    GridPane.setHalignment(text11, HPos.CENTER);
    GridPane.setHalignment(text01, HPos.CENTER);

    Scene scene = new Scene(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
}