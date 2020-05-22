public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addNode(new Node(null, 1));
    list.addNode(new Node(null, 2));
    list.addNode(new Node(null, 3));
    list.addNode(new Node(null, 4));
    list.addNode(new Node(null, 123));
    list.addNode(new Node(null, 5));
    list.addNode(new Node(null, 6));
    list.listValues();


    list.delete(1);
    System.out.println("-----");
    list.listValues();

    list.delete(123);
    System.out.println("-----");
    list.listValues();


    list.addNode(new Node(null, 123));
    list.addNode(new Node(null, 5));

    list.delete(2);
    System.out.println("-----");
    list.listValues();

    list.delete(26);
    System.out.println("-----");
    list.listValues();
}