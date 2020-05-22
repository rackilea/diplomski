public void selectionSort(IntNode head) {
    for (IntNode node1 = head; node1 != null; node1 = node1.getLink()) {
        IntNode min = node1;
        for (IntNode node2 = node1; node2 != null; node2 = node2.getLink()) {
            if (min.getData() > node2.getData()) {
                min = node2;
            }

        }
        IntNode temp = new IntNode(node1.getData(), null);
        node1.setData(min.getData());
        min.setData(temp.getData());
    }
}