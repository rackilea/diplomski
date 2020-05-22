public class RegionBorder extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Region region = new Region();
        // Standard color, width, etc ...
        region.getStyleClass().add("myborderedregion");

        BorderPane bp = new BorderPane();
        bp.setCenter(region);

        ColorPicker cp = new ColorPicker();
        // Change only the color
        cp.valueProperty().addListener((obs, oldval, newval) -> 
                region.setStyle("-fx-border-color: " + String.format( "#%02X%02X%02X",
                (int)( cp.getValue().getRed() * 255 ),
                (int)( cp.getValue().getGreen() * 255 ),
                (int)( cp.getValue().getBlue() * 255 ) )));

        bp.setBottom(cp);

        Scene scene = new Scene(bp, 500, 500);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}