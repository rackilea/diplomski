public class Test extends Application {
    private Stage window;
    private static Things things;

    public void start(Stage stage) throws Exception {
        window = new Stage();
        window = stage;
        Pane layout = new Pane();
        Scene scene = new Scene(layout);

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                close();
            }
        });
        window.setScene(scene);
        window.show();
    }


    // on close
    public void close() {
        window.close();
        things.stop();  // stop the things object directly
    }

    public static void main(String[] args) {
        things = new Things();  // create new runnable
        Thread t = new Thread(things,"Monitor"); // create thread
        t.start();  // start thread
        launch(args);  // launch app
    }
}