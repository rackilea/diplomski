public static Node getNodeTree(String[] leaves) {
        if (leaves.length == 1) {
            return new Node(leaves[0]);
        }

        return new Node(leaves[0], getNodeTree(Arrays.copyOfRange(leaves, 1, leaves.length)));
    }