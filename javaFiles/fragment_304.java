boolean expanded = true to expand, false to collapse

Tree tree = ... your tree

tree.setRedraw(false);  // Stop redraw until operation complete

TreeItem [] items = tree.getItems();

for (TreeItem item : items) {
   item.setExpanded(expanded);
}

tree.setRedraw(true);