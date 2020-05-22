public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        final ImageView imageView = new ImageView();
        imageView.setImage(new Image("https://upload.wikimedia.org/wikipedia/en/c/cc/JavaFX_Logo.png"));
        imageView.setPreserveRatio(true);

        Screen primaryScreen = Screen.getPrimary();
        Rectangle2D visualBounds = primaryScreen.getVisualBounds();
        double width = visualBounds.getWidth();
        double height = visualBounds.getHeight();

        StackPane stackPane = new StackPane(imageView);
        Scene scene = new Scene(stackPane, width, height);

        imageView.fitWidthProperty().bind(scene.widthProperty().subtract(20));
        stage.setScene(scene);
        stage.show();
    }

}