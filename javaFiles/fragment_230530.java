private static LinkedList sortList(LinkedList list) {
    // I use an ArrayList so I can just use Collections.sort
    LinkedList sortedList = new LinkedList();
    Node current = list.head;
    ArrayList<Node> array = new ArrayList<Node>();

    while (current != null) {
        array.add(current);
        current = current.link;
    }
    array.sort(new NodeComparator());

    for (int i = array.size()-1; i >= 0; i--) {
        sortedList.insertFirst(array.get(i));
    }

    return sortedList;
}