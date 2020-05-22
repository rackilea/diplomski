public class Main extends Application {
   public static void main(String[] args) {
          launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      String fxmlResource = "MainWindow.fxml";
      Parent panel;
      panel = FXMLLoader.load(getClass().getResource(fxmlResource));
      Scene scene = new Scene(panel);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.show();
   }
}