@FXML
private void fillTreeView() {
    // The tree needs a root, and it needs to be a DocumentObject
    // so we create an empty folder and hide it
    TreeItem<DocumentObject<?>> treeRoot = new TreeItem<>(new Folder());

    ObservableList<TreeItem<DocumentObject<?>>> firstLevel = FXCollections.observableArrayList();

    for (Folder folder : logic.getFolderList()) {
        TreeItem<DocumentObject<?>> folderNode = new TreeItem<>(folder);

        for (FileReference file : folder.getFileList()) {
            TreeItem<DocumentObject<?>> fileNode = new TreeItem<>(file);
            folderNode.getChildren().add(fileNode);
        }

        firstLevel.add(folderNode);
    }

    treeRoot.setExpanded(true);


    FilteredList<TreeItem<DocumentObject<?>>> filteredList = new FilteredList<>(firstLevel, item -> true);

    filteredList.predicateProperty().bind(Bindings.createObjectBinding(() -> {
        String filter = textField.getText();
        if (filter.isEmpty()) return item -> true ;
        return item -> item.getValue().getName().startsWith(filter) ; // your implementation may vary...
    }, textField.textProperty());

    Bindings.bindContent(treeRoot.getChildren(), filteredList);

    treeNav.setRoot(treeRoot);
    treeNav.setShowRoot(false);
}