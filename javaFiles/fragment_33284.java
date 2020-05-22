public class Source extends Application {
    public static ArrayList<Path> paths = new ArrayList<>();

    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Path path = new Path();
                paths.add(path);
                path.getElements().add(new MoveTo(event.getX(),event.getY()));

                scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        path.getElements().add(new LineTo(event.getX(),event.getY()));
                    }
                });
                root.getChildren().add(path);
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}