static List<Node> DFS(Node n) {

    Stack<Node> current = new Stack<>();
    Set<Node> visited = new HashSet<>(); // efficient lookup
    List<Node> result = new ArrayList<>(); // ordered

    current.push(n);

    while(!current.isEmpty()) {
        Node c = current.pop();
        if(!visited.contains(c)) {
            result.add(c);
            visited.add(c);
            // push in reversed order
            IntStream.range(0, c.getChildren().size())
                    .forEach(i -> current.push(c.getChildren().get(c.getChildren().size() - i - 1)));
        }
    }

    return result;
}