public void createSingleTreeNode(JSONObject obj, javax.swing.tree.DefaultMutableTreeNode master) {

    javax.swing.tree.DefaultMutableTreeNode[] nodes = {};

    for(Iterator iterator = obj.keySet().iterator(); iterator.hasNext();) {

        String key = (String) iterator.next();

        if (obj.get(key) instanceof JSONObject) {

        javax.swing.tree.DefaultMutableTreeNode node1 = new javax.swing.tree.DefaultMutableTreeNode(key);

        LT.createSingleTreeNode((JSONObject) obj.get(key), node1);

        master.add(node1);

        } else {

        nodes = Arrays.copyOf(nodes, nodes.length + 1);

        nodes[nodes.length - 1] = new javax.swing.tree.DefaultMutableTreeNode(key);

        }

    }

    for (DefaultMutableTreeNode node : nodes) {

        master.add(node);

    }

}