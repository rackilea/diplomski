Deque<Node> queue = new ArrayDeque<Node>();
queue.add(root);
while(!queue.isEmpty()) {
    Node node = queue.poll();
    while (node != null) {
        System.out.println(node.data);
        if (node.subtree != null) {
            queue.add(node.subtree); // to visit the nodes on the next level
        }
        node = node.next; // to visit the other nodes on the same level
    }
}