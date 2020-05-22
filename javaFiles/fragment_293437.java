public class Example extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane stackPane = new StackPane();

        Button bigButton = new Button("I'm not clickable");
        bigButton.setOnAction(e -> System.out.println(e));
        bigButton.setMaxHeight(Double.MAX_VALUE);
        bigButton.setMaxWidth(Double.MAX_VALUE);
        stackPane.getChildren().add(bigButton);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPrefHeight(Double.MAX_VALUE);
        vbox.setPrefWidth(400);

        ObservableList<Node> vChildren = vbox.getChildren();
        Button button1 = new Button("This");
        button1.setOnAction(e -> {
            System.out.println(e);
            e.consume();
        });
        Button button2 = new Button("Button");
        button2.setOnAction(e -> {
            System.out.println(e);
            e.consume();
        });
        Button button3 = new Button("Are clickable");
        button3.setOnAction(e -> {
            System.out.println(e);
            e.consume();
        });

        vChildren.addAll(button1, button2, button3);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);

        vbox.prefWidthProperty().bind(bigButton.widthProperty());
        vbox.prefHeightProperty().bind(bigButton.heightProperty());

        bigButton.setGraphic(borderPane);

        stage.setScene(new Scene(stackPane, 800, 600));
        stage.show();
    }
}