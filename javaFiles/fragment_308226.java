@Override
public void start(Stage primaryStage) {

    Service<Void> service = new Service<Void>() {
        @Override protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override protected Void call() throws InterruptedException {
                    updateMessage("Message . . .");
                    updateProgress(0, 10);
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(300);
                        updateProgress(i + 1, 10);
                        updateMessage("Progress " + (i + 1) + " of 10");
                    }
                    updateMessage("End task");
                    return null;
                }
            };
        }
    };

    Button btn = new Button("Start Service");
    btn.setOnAction(e -> {
        ProgressDialog dialog = new ProgressDialog(service);
        dialog.setTitle("Progress Dialog");
        dialog.setHeaderText("Header message");
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("<image>.png").toString()));
        service.start();
    });

    Scene scene = new Scene(new StackPane(btn), 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
}