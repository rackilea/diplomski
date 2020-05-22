@FXML
public void stopButtonAction(ActionEvent e) {
    shutdown();
}

public void shutdown() {
    if (started) {
        server.setRunning(false);
        chatEvent_txt.setText("Server wurde gestoppt\n");
        started = false;
    }
}