public abstract class SuperType {
    @FXML
    private Label lblSysMsg;

    public void setSystemMessage(String message) {
        lblSysMsg.setText(message);
    }
}