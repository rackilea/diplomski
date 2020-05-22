public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            primaryStage.setTitle("Stage with 400x400 Scene");
            primaryStage.setScene(scene);

            primaryStage.setOnShown(event -> System.out.println("Size of the Stage is " + primaryStage.getHeight() + "x" + primaryStage.getWidth()));

            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}