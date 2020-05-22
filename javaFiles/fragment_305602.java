public class Main extends Application {
      @Override
      public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 260, 80);
        stage.setScene(scene);

        Group g = new Group();

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0 });

        g.getChildren().add(polygon);

        scene.setRoot(g);
        stage.show();
      }

      public static void main(String[] args) {
        launch(args);
      }
    }