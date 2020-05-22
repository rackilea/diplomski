@FXML
private BorderPane container;

@FXML private void savingsCreateDeleteAccountOnAction() throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("savingsCreateDeleteAccount.fxml"));
    Pane tempPane = fxmlLoader.load();
    container.setCenter(tempPane);
}