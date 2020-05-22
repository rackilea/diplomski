final Stage dialog = new Stage();
dialog.initOwner(window);
dialog.initModality(Modality.WINDOW_MODAL);
dialog.sizeToScene();
dialog.setScene(scene);

Platform.runLater(new Runnable() {
    @Override
    public void run() {
        dialog.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - dialog.getWidth() / 2); //dialog.getWidth() = NaN
        dialog.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - dialog.getHeight() / 2); //dialog.getHeight() = NaN
    }
});
dialog.showAndWait();