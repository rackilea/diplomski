@Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Image image = new Image(MyClass.class.getResource("Water lilies.jpg").toExternalForm());
        Scene scene = new Scene(root, image.getWidth(), image.getHeight(), Color.WHITE);
        final ImageView view = new ImageView();
        view.setImage(image);

        xCordinate = new SimpleDoubleProperty(100.0f);
        yCordinate = new SimpleDoubleProperty(100.0f);


        final Circle c1 = new Circle();
        c1.centerXProperty().bind(xCordinate);
        c1.centerYProperty().bind(yCordinate);
        c1.setRadius(50.0f);

        final Circle c2 = new Circle();
        c2.centerXProperty().bind(xCordinate);
        c2.centerYProperty().bind(yCordinate);
        c2.setRadius(35.0f);

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xCordinate.set(event.getX());
                yCordinate.set(event.getY());
                System.out.println("xCordinate " + xCordinate + " yCordinate " + yCordinate);
                // update mask clip
                Shape mask = Path.subtract(c1, c2);
                view.setClip(mask);
            }
        });

        Shape mask = Path.subtract(c1, c2);
        view.setClip(mask);

        root.getChildren().add(view);
        primaryStage.setScene(scene);
        primaryStage.show();
    }