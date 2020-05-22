public class Main extends Application {

    private Player pUser;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 500, 300);
        ObservableList list = root.getChildren();

        KeyPressedChecker kpc = new KeyPressedChecker();

        scene.addEventHandler(KeyEvent.ANY, kpc);

        pUser = new Player(kpc);

        list.add(pUser.getPaddleDrawable());

        GamePlayLoop gameLoop = new GamePlayLoop(pUser);
        gameLoop.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}