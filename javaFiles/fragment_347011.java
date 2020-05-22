@FXML
private void handleModalButton(ActionEvent e) throws IOException
{
    DialogModal modal = new DialogModal("Modal.fxml", 400, 450);
    FooController controller = modal.showDialogModal((Button)e.getSource());

    String data1 = controller.getTextField1Data();
    // ...
}