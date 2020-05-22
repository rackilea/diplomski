private TreeNode root;

private TreeNode selectedNode;

public TreeBean() {
root = new DefaultTreeNode("Root", null);
List rootNodes<Employee> = SearchDao.getRootNodes();

Iterator it = rootNodes.iterator();
while (it.hasNext()) {

TreeNode node1 = new DefaultTreeNode(**it.next()**, root);
    **/* in place of it.next() I need to display empName. When I click on empName, I need to get the Id(Pkey). */**

}

}

public TreeNode getRoot() {
return root;
}

public TreeNode getSelectedNode() {
return selectedNode;
}

public void setSelectedNode(TreeNode selectedNode) {
this.selectedNode = selectedNode;
}



public void addChildNode(ActionEvent actionEvent) {
System.out.println("Selected Node: "+getSelectedNode().toString());
TreeNode newNode = new DefaultTreeNode("Node New", getSelectedNode());
getSelectedNode().setExpanded(true);
}
public void addTopicBelow(ActionEvent actionEvent){
TreeNode newNode = new DefaultTreeNode("Node New", getSelectedNode().getParent());
}
public void deleteNode(ActionEvent actionEvent){
 System.out.println("Node to be deleted: "+getSelectedNode().toString());
 //getSelectedNode().
}