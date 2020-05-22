public void renameFile(ActionEvent actionEvent) {
    TextInputDialog dialog = new TextInputDialog("Rename");
    dialog.setTitle("Rename");
    dialog.setHeaderText("Rename File");
    dialog.setContentText("New name");
    Optional<String> res = dialog.showAndWait();
    if (res.isPresent()) {
        try {
            Path paths = Paths.get("client_storage/" + ClientListView.getSelectionModel().getSelectedItem());
            Files.move(paths, paths.resolveSibling(res.get()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}