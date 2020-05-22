DefaultMutableTreeNode rootNode = ...;
DefaultMutableTreeNode groupNode = null;
String currentGroup = null;
while (resultSet.next()) {
    String group = resultSet.getString("colNode");
    if (currentGroup == null || !currentGroup.equals(group)) {
        currentGroup = group;
        group = new DefaultMutableTreeNode(group);
        rootNode.add(groupNode);
    }
    group.add(new DefaultMutableTreeNode(resultSet.getString("colLeaf")));
}