public class JavaFXApplication extends Application {

    Rectangle rect = new Rectangle(100,100);

    @Override
    public void start(Stage primaryStage) {
        rect.setFill(Color.BLUE);

        rect.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                rect.setFill(Color.RED);
            }
        });


        StackPane root = new StackPane();
        root.getChildren().add(rect);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}