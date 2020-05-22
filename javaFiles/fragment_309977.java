public void visitTree(Item head) {
    Queue<Item> queue = new PriorityQueue<Item>();
    while (queue.size() > 0) {
        Item curr = queue.poll();
        // Do something
        for (Item i : curr.getChildren())
            queue.add(i);
    }
}