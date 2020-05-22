Button sendButton;
TextArea area;
// init...

// set handlers
sendButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
         sendFunction();
    }
});

area.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)  {
             sendFunction();
        }
    }
});

// define send function
public void sendFunction() {
    String text = this.area.getText();

    // do the send stuff

    // clear text (you may or may not want to do this here)
    this.area.setText("");
}