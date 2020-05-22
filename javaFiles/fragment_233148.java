public TreeNode constructActualModel(TreeAutocompleteMatcherIface matcher) {
    if (prunedModel == null) {
        eraseHierarchyStructure();
        prunedModel = copyHierarchy((TreeNode) completeModel, getVisibleNodes(matcher));
    }
    return prunedModel;
}

/**
 * Recursively copy the hierarchy and prune not visible branches
 * @param originalNode node of the original hierarchy to be copied
 * @param visibleNodes set of nodes, which should be included in the new hierarchy
 * @param model model of the TreeAutompleteComponent
 * @return copy of the oroginal node in the new hierarchy
 */
private TreeNode copyHierarchy(TreeNode originalNode, Set<TreeNode> visibleNodes) {
    if (!visibleNodes.contains(originalNode)) {
        return null;
    }

    TreeNode newNode = this.getCompleteModelNodes().get(((NodeWrapper) originalNode.getData()).getIri());//new DefaultTreeNode(originalNode.getData(), parent);
    List<TreeNode> children = new ArrayList<TreeNode>();
    for (int i = 0; i < originalNode.getChildCount(); i++) {
        TreeNode child = copyHierarchy((TreeNode) originalNode.getChildren().get(i), visibleNodes);
        if(child != null){
            children.add(child);
        }
    }
    ((DefaultTreeNode) newNode).setChildren(children);
    return newNode;
}

private void eraseHierarchyStructure() {
    for (TreeNode node : duplicateCompleteModelNodes.values()) {
        node.setParent(null);
    }       
}