public static void main(String args[]) {
    IntNode head = new IntNode(-1, null);
    Sorter sorter = new Sorter();

    head.addAfter(4);
    head.addAfter(5);
    head.addAfter(2);
    head.addAfter(3);
    head.addAfter(6);
    head.addAfter(9);
    head.addAfter(8);
    head.addAfter(10);

    sorter.selectionSort(head);

    for (IntNode i = head; i != null; i = i.getLink()) {
        System.out.println(i.getData());
    }
}