public static ArrayList<BtreeNode> asList(BtreeNode node) {
    ArrayList<BtreeNode> result = new ArrayList<BtreeNode>();
    traverse(node, result);
    Collections.sort(result, new Comparator<BtreeNode>() {
        @Override
        public int compare(BtreeNode arg0, BtreeNode arg1) {
            if (arg0.data < arg1.data)
                return -1;
            else if (arg0.data > arg1.data)
                return 1;
            return 0;
        }
    });
    return result;
}

private static void traverse(BtreeNode node, ArrayList<BtreeNode> result) {
    if (node.L != null) {
        traverse(node.L, result);
    }
    result.add(node);
    if (node.R != null) {
        traverse(node.R, result);
    }
}