final FXMLLoader isLoader = new FXMLLoader(Main.class.getResource("/view/itemStep.fxml"));
final AnchorPane pane = isLoader.load();
final Scene scene = new Scene(pane);
final Stage stage = new Stage();
stage.initModality(Modality.APPLICATION_MODAL);
stage.setScene(scene);

listViewVariable.setOnMouseClicked(event -> {    
    if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && (mouseEvent.getClickCount() == 2)) {
        ItemStep item = listViewVariable.getSelectionModel().getSelectedItem();
        if (item != null) {
            stage.showAndWait();
            item.setUrl(item.urlField.getText());
        }
    }
});