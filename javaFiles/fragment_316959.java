@Override
public void start(Stage primaryStage) {
    imageView.setImage(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/800px-Siberischer_tiger_de_edit02.jpg"));
    imageView.setPreserveRatio(true);

    StackPane root = new StackPane();
    root.getChildren().add(imageView);
    root.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
        double w = newValue.getWidth();
        double h = newValue.getHeight();
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
        double ratio = h / w;
        Image image = imageView.getImage();
        double ih = image.getHeight();
        double iw = image.getWidth();
        double vR = ih / iw;
        imageView.setViewport((ratio < vR) ? new Rectangle2D(0, 0, iw, iw * ratio) : new Rectangle2D(0, 0, ih / ratio, ih));
    });

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Test Image Resizing");
    primaryStage.setScene(scene);
    primaryStage.show();
}