public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Just on example how it could be done...
        Controller controller = new Controller();
        MyMainComponent mainComponent = new MyMainComponent(controller);
        mainComponent.showIn(stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}