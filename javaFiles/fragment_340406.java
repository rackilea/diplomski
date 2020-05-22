setVisible(false);
tree.removeTreeWillExpandListener(this);
tree.removeTreeSelectionListener(this);

//modify the tree

tree.addTreeSelectionListener(this);
tree.addTreeWillExpandListener(this);
setVisible(true);