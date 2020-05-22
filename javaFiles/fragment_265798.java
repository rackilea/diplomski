while (tree.next)
            if (tree.getDepth == cleanPath.size) {
                // we are at the right level, do what you want
            } else {
                if (tree.isSubtree &&
                    name == cleanPath(tree.getDepth)) {
                    tree.enterSubtree
                }
            }
    }