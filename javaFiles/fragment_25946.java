private void getRowData(NodeGrid data, TreeNode<?> currentNode, int depth) {
    if (currentNode.isLeaf()) {
        data.addData(String.valueOf(currentNode.getData()));
        data.newRow();
    } else {
        data.addData(String.valueOf(currentNode.getData()));
        getRowData(data, currentNode.getChild(0), depth + 1);
        for (int i = 1; i < currentNode.getChildren().size(); i++) {
            for (int d = 0; d < depth + 1; d++) {
                data.addData("");
            }
            getRowData(data, currentNode.getChild(i), depth + 1);
        }
    }
}