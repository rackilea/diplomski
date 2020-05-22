public NodeBase findEmployee (NodeBase root, Integer employeeId) {
    Queue<NodeBase> q= new LinkedList<NodeBase>();
    q.add(root);
    while (!q.isEmpty()) {
        NodeBase node= q.poll();
        if (node instanceof Employee) {
            if (((Employee)node).getId().equals(employeeId))
                return node;
        }
        for (NodeBase child : node.getChildren())
            q.add(child);
        }
    }
}