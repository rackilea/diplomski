for (Node lt : possibleLeftSubtrees) {
        for (Node rt : possibleRightSubtrees) {
            // make a tree of a node with lt and rt as subtrees,
            // and add it to the result
            result.add(new Node(i,lt, rt));
        }
    }