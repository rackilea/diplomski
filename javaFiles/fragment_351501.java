// This queue will hand out nodes in the inverse order of their frequency
PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
        return -a.compareTo(b);
    }
});