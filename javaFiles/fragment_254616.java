public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hi I'm a title");

        EventHandler eventHandler = new BiteHandler("You've been bitten");

        Button biteMeButton = new Button();
        biteMeButton.setText("Bite me");

        Button biteMeAgainButton = new Button();
        biteMeAgainButton.setText("Bite me again");

        biteMeButton.setOnAction(eventHandler)
        biteMeAgainButton.setOnAction(eventHandler);

        StackPane pane = new StackPane();
        pane.getChildren().add(biteMeButton);
        pane.getChildren().add(biteMeAgainButton);

        Scene scene = new Scene(pane, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}