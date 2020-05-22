public class SampleApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Label lbl1 = new Label("content");
        final TitledPane tp1 = new TitledPane("First TP", lbl1);

        final Label lbl2 = new Label("more content");
        final TitledPane tp2 = new TitledPane("Second TP", lbl2);

        final VBox rootPane = new VBox(tp1, tp2);

        tp1.heightProperty().addListener((InvalidationListener) observable -> {
            updateWindowHeight(rootPane);
        });

        tp2.heightProperty().addListener((InvalidationListener) observable -> {
            updateWindowHeight(rootPane);
        });

        final Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void updateWindowHeight(final VBox rootPane) {
        final Scene scene = rootPane.getScene();
        if (scene == null) 
            return;
        final Window window = scene.getWindow();
        if (window == null)
            return;
        final double rootPrefHeight = rootPane.prefHeight(-1);
        final double decorationHeight = window.getHeight() - scene.getHeight(); // window decorations
        window.setHeight(rootPrefHeight + decorationHeight);
    }

    public static void main(String[] args) {
        launch(args);
    }
}