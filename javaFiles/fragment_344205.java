private Runnable tabCloseHandler;

public void setTabCloseHandler(Runnable handler) {
    tabCloseHandler = handler;
}

@FXML
public void deleteButton(ActionEvent e) {
    // you don't set the handler here; this method is invoked as handler
    String mess = "You clicked: " + e.getSource() + "!";
    System.out.println(mess);

    if (handler != null) {
        handler.run();
    }
}