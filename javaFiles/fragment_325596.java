public class SmartBorder extends Application {

    @Override
    public void start(Stage primaryStage) {

        final Label txt = new Label("Example");
        txt.relocate(100, 100);

        Pane root = new Pane();

        final Rectangle border = new Rectangle();
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.RED);

        // here we autoupdate border 
        txt.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {

            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds old, Bounds b) {
                border.setX(b.getMinX() - 1);
                border.setY(b.getMinY() - 1);
                border.setWidth(b.getWidth()+2);
                border.setHeight(b.getHeight()+2);
            }
        });

        root.getChildren().addAll(txt, border);

        // click to see automatic border reaction
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                txt.relocate(Math.random()*200, Math.random()*200);
                txt.setText(Math.random() + "");
            }
        });
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}