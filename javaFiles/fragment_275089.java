private static Collection<Node> createGraphNodes(int[][] pointsMatrix) {
    Map<Integer, Node> nodes = new HashMap<Integer, Node>();
    for(int[] points: pointsMatrix) {
        for(int point: points) {
            if(nodes.containsKey(Integer.valueOf(point))) {
                continue;
            }

            Node node = new Node();
            node.setId(point);
            nodes.put(point, node);
        }
    }

    for(int[] points: pointsMatrix) {
        int nodeId1 = points[0];
        int nodeId2 = points[1];

        Node node1 = nodes.get(Integer.valueOf(nodeId1));
        Node node2 = nodes.get(Integer.valueOf(nodeId2));

        node1.getAdjacentNodes().add(node2);
        node2.getAdjacentNodes().add(node1);

    }

    return nodes.values();