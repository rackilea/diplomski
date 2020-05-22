public void initData(RootNode data)
{
    TreeItem<String> rootItem = new TreeItem<>();
    rootItem.valueProperty().bind(data.nameProperty());
    treeView.setRoot(rootItem);
    for (NodeOne nodeOne : data.getNodes())
    {
        TreeItem<String> oneItem = new TreeItem<>();
        oneItem.valueProperty().bind(nodeOne.nameProperty());
        rootItem.getChildren().add(oneItem);
        for (NodeTwo nodeTwo : nodeOne.getNodes())
        {
            TreeItem<String> twoItem = new TreeItem<>();
            twoItem.valueProperty().bind(nodeTwo.nameProperty().concat(": ").concat(nodeTwo.descriptionProperty()));
            oneItem.getChildren().add(twoItem);
        }
    }
}