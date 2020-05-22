public class WarbladeFX extends Application {

    Game root;

    public void start(Stage primaryStage) {
        root = new Game();
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(new Color(0,0,0,1));


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                game.keyDown(event.getCode().toString());
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                game.keyUp(event.getCode().toString());
            }
        });


        primaryStage.setTitle("WarbladeFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}