public void minimumSpanningTree(String root) {

        ArrayList<Node> msTree = new ArrayList<>();

        Node rootNode = null;
        for (Node vertex: this.weightedGraph) {
            vertex.setKey(Integer.MAX_VALUE);
            vertex.setDaddy(null);
            if (vertex.getLabel().contains(root)) {
                rootNode = vertex;
            }
        }

        rootNode.setKey(0);

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();

        for (Node vertex: this.weightedGraph) {
            nodePriorityQueue.add(vertex);
        }
        int min = 0;
        while (!nodePriorityQueue.isEmpty()) {

            Node u = nodePriorityQueue.peek();

            LinkedList<Edge> uEdges= u.getEdges();
            for (Edge e: uEdges) {
                Node v = e.getDestination();
                int u_vWeight = e.getWeight();
                if (nodePriorityQueue.contains(e.getDestination()) && u_vWeight < v.getKey()) {
                    nodePriorityQueue.remove(v);
                    v.setDaddy(u);
                    v.setKey(u_vWeight);
                    nodePriorityQueue.add(v);
                }
            }
            msTree.add(u);
            System.out.println(u.getLabel());
            nodePriorityQueue.remove(u);
        }