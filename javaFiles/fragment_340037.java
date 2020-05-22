public void onBtnActionCategory(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/category.fxml"));
    loader.setControllerFactory(context::getBean);
    Node change = loader.load();
    setPane(change);
}