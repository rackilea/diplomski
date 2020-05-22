public TreeNode buildTree(){
    String[] names = new String[]; // fill this with the names of your plugins

    TreeNode tree;

    // for each plugin name...
    for (int i=0;i<names.length;i++){
        String currentName = names[i];
        String[] splitName = currentName.split(".");

        // loop over the split name and see if the nodes exist in the tree. If not, create them
        TreeNode parent = tree;
        for (int n=0;n<splitName.length;n++){
            if (parent.hasChild(splitName[n])){
                // the parent node exists, so it doesn't need to be created. Store the node as 'parent' to use in the next loop run
                parent = parent.getChild(splitName[n]);
            }
            else {
                // the node doesn't exist, so create it. Then set it as 'parent' for use by the next loop run
                TreeNode child = new TreeNode(splitName[n]);
                parent.addChild(child);
                parent = child;
            }
        }

return tree;
}