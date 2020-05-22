private final Map<URL, Node> loadedContent = new HashMap<>();

@FXML
private void handlePanelButtonAction(ActionEvent event) {
    loadedContent.computeIfAbsent(getResource(event.getSource()), url -> {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            Node result = loader.load();
            ClientContainer controller = loader.getController();
            controller.setClient(client);
            mainPane.getChildren().add(result);
            return result;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }).toFront();
}