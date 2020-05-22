public class MainApp extends Application {
    private EditorOverviewController editorOverviewController ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // as before ...
    }

    private void initRootLayout() {
        // as above ...
    }

    private void showEditorOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditorOverview.fxml"));
            AnchorPane editorOverview = (AnchorPane) loader.load();

            // Set editor overview into the center of root layout.
            rootLayout.setCenter(editorOverview);

            // note subtle change here:
            this.editorOverviewController = loader.getController();

            // again, should not need this:
            // controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}