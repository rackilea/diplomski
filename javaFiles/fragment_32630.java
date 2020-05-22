public static Node createNodes(Map<List<String>, Integer> map) {
    Map<String, Node> namemap = new HashMap<String, Node>();
    Node root = new Node();
    Node current;
    for (Entry<List<String>, Integer> path : map.entrySet()) {
        current = root;
        for (String nodename : path.getKey()) {
            Node p;
            if (!namemap.containsKey(nodename)){
                p = new Node(nodename, path.getValue());
                namemap.put(nodename, p);
            }else {
                p = namemap.get(nodename);
                p.addCost(path.getValue());
            }
            current.addChild(p);
            current = p;
        }

    }

    return root;
}