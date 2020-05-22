if (node.getParent() != null) {
        if (node.getParent().left() != null && node.getParent().left().root == node)
            node.getParent().setLeft(null);
        else
            node.getParent().setRight(null);
    }