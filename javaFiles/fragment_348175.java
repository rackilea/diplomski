List<TreeItem<Object>> children = 
treeView.getSelectionModel().getSelectedItem().getChildren();

for (TreeItem<Object> child : children) {
    System.out.println(child.getValue())
}