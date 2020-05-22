try {
    [...]
}  catch (Exception e) {
    Platform.runLater(new Runnable() {
    @Override public void run() {
        new Alert(AlertType.ERROR).showAndWait();
        Platform.exit();
    });
}