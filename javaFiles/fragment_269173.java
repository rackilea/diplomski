class Node {
    public static void main(String[] args) {
        HashMap<String, Node> nodes = new HashMap<String, Node>();
        try {
            while (readLine()) {
                String user1 = "user1";
                String user2 = "user2" ;
                int value = 1;
                Node node1 = nodes.get(user1);
                if (node1 == null) {
                    node1 = new Node("user1");
                }
                Node node2 = new Node("user2");
                node1.getNodes().put(node2, value);
                nodes.put("user1", node1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public HashMap getNodes() {
        return nodes;
    }

    public void setNodes(HashMap nodes) {
        this.nodes = nodes;
    }

    public Node(String key) {
        this.key = key;
    }
    private String key;
    private HashMap nodes = new HashMap<Node, Integer>();
}