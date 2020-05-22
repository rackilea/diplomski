DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root node name");
for( String book : booksArray ) {
    DefaultMutableTreeNode bookNode = new DefaultMutableTreeNode(book);
    rootNode.add(bookNode);
}

tree1 = new JTree(rootNode);
tree1.setRootVisible(true);
[...]