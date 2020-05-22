public GeneralTreeNode findNode(String targetName) {          
    if (this.name.equals(targetName)) {
        return this;
    } else {
        for (GeneralTreeNode child : this.children) {
            GeneralTreeNode childResult = child.findNode(targetName);

            if (childResult != null) {
                return childResult;       // only return if you really found something
            }
        }
    }

    // no node containing the string could be found
    return null;  
}