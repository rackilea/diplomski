@FXML
private void apply() {
    loading.setVisible(true);

    Task<Void> applyTask = new Task<Void>() {

        @Override
        protected Void call() throws Exception {

            Thread.sleep(10000);//sleep for 10 seconds just to show that the progress indicator is working

            directory = Paths.get(pathField.getText()).toFile();
            if (directory != null) {
                //fx-parts need to be executed by Platform.runLater(...)
                Platform.runLater(() -> pieChartData.clear());

                String strings = new String(pathField.getText());
                calc.calcSubfoldersSize(strings);

                //again let fx-parts be executed in the fx-application-thread
                Platform.runLater(() -> updataLabads());
            }

            return null;
        }
    };

    applyTask.setOnSucceeded(e -> loading.setVisible(false));
    applyTask.setOnFailed(e -> loading.setVisible(false));//handle error here...

    new Thread(applyTask, "Apply thread").start();

    //loading.setVisible(false); //done when the task ends
}