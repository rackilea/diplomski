public <T> T showDialogModal(Button root) throws IOException
{
    Stage modalDialog = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource( fxmlURL ));
    Parent modalDialogRoot = loader.load();
    T controller = loader.getController(); // Retrieve the controller
    Scene modalScene = new Scene( modalDialogRoot, width, height );
    modalScene.getStylesheets().add(InventoryManager.class.getResource("InventoryManager.css").toExternalForm());
    modalDialog.initOwner(root.getScene().getWindow());
    modalDialog.setScene(modalScene);
    modalDialog.setResizable(false);

    // You need Platform.runLater() so that this method doesn't get blocked
    Platform.runLater(() -> modalDialog.showAndWait());

    return controller; // Return the controller back to caller
}