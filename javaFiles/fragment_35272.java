class SplashScreen extends Task {
    @Override
    public Object call() throws IOException, InterruptedException {
        Thread.sleep(3000);
        final Parent root = FXMLLoader.load(getClass().getResource("../gui/NewUI.fxml"));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);

                Scene scene = new Scene(root, 1280, 720);
                stage.setScene(scene);
                stage.show();
                MainJavaFx.setPrimaryStage(stage);
                ((Stage) panParent.getScene().getWindow()).close();
            }
        });
        return null;
    }
}