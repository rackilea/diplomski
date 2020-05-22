public class Main extends Application {
    SimpleBooleanProperty isKeyPress = new SimpleBooleanProperty(false);
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent window = new VBox();
        ((VBox) window).getChildren().add(new Label("example of small window:"));
        primaryStage.setTitle("example");
        Scene scene=new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("Press");
                isKeyPress.set(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Scene alertScene = alert.getDialogPane().getScene();
                alertScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        System.out.println("Released on dialog");
                        isKeyPress.set(false);

                    }
                });
                alert.showAndWait();
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("Released");
                isKeyPress.set(false);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}