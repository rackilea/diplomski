public class App extends Application {

  public static void main(String[] args) { launch(); }

  public static String parameters;

  @Override
  public void start(Stage primaryStage) throws Exception {

    parameters = getParameters().getNamed().toString();

    Parent root = FXMLLoader.load(getClass().getResource("MyView.fxml"));
    final Scene scene = new javafx.scene.Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}