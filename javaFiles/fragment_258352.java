public class AutoClose {
    private Timeline timer;

    public AutoClose(VBox mainPanel) {

        timer = new Timeline(new KeyFrame(Duration.seconds(3600), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent evt) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inactivity");
                alert.setHeaderText("Connection closed due to inactivity");
                alert.show();

                try {
                    Stage mainWindowStage = Login.getPrimaryStage();

                    Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

                    Scene scene = new Scene(root);
                    mainWindowStage.setScene(scene);
                    mainWindowStage.show();

                    timer.stop();
                } catch (IOException ex) { 
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        mainPanel.addEventFilter(MouseEvent.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                timer.playFromStart();
            }
        });
    }
}