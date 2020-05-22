public class BookingApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        SplitPane split = new SplitPane();
        split.getItems().addAll(createBookingFlow(), createBookingFlow());
        split.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(split, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createBookingFlow() {
        // see above...
    }

    private Node load(String resource, ControllerFactory controllerFactory) {
        // see above...
    }

    public static void main(String[] args) {
        launch(args);
    }
}