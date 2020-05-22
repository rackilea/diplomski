public class Main extends Application {
    StackPane root = new StackPane();
    Time time;
    Text t1 = new Text(); // Instantiates only once

    @Override
    public void start(Stage primaryStage) throws Exception{
        root.setStyle("-fx-background-color: #00FF00");
        primaryStage.setTitle("My App");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();

        root.getChildren().add(t1);

        checkTime();


        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void checkTime(){
        time = new Time(this); // Pass ownself into Time
        time.start();
    }

    public void updateTime(int hour, int minute, int second){
        Platform.runLater(() -> t1.setText(200, 50, hour + ":" + minute + ":" + second));
    }
}