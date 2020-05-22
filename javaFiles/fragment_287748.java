public static DefaultMutableTreeNode sortTree(DefaultMutableTreeNode root) {
    {
        for (int i = 0; i < root.getChildCount() - 1; i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
                    .getChildAt(i);
            String nt = node.getUserObject().toString();

            for (int j = i + 1; j <= root.getChildCount() - 1; j++) {
                DefaultMutableTreeNode prevNode = (DefaultMutableTreeNode) root
                        .getChildAt(j);
                String np = prevNode.getUserObject().toString();

                System.out.println(nt + " " + np);
                if (nt.compareToIgnoreCase(np) > 0) {

                    root.insert(node, j);
                    break;
                }
            }
            if (node.getChildCount() > 0) {
                node = sortTree(node);
            }
        }

        return root;
    }
}