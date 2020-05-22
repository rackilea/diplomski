static List<Node> DFSreversedPostOrder(Node n) {

    Stack<Node> current = new Stack<>();
    Set<Node> visited = new HashSet<>(); // efficient lookup
    List<Node> result = new ArrayList<>(); // ordered

    current.push(n);

    while(!current.isEmpty()) {
        Node c = current.pop();
        if(!visited.contains(c)) {
            result.add(0, c);
            visited.add(c);
            c.getChildren().forEach(current::push);
        }
    }

    return result;
}