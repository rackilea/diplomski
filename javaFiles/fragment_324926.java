private void initRootLayout() {
    try {
        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

        // Give the controller access to the main app.
        RootLayoutController controller = loader.getController();

        // really should not need this ugly coupling from your controllers back to the app
        // controller.setMainApp(this);

        controller.selectedFileProperty().addListener((obs, oldFile, newFile) -> {
            if (newFile != null) {
                editorOverviewController.loadXmlFile(newFile);
            }
        }

        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}