public static void main(String args[]) {
    Node n1 = new Node(1,2);
    List l = new List();
    l.insert(0,n1);

    Node n2 = new Node(3,2);
    l.insert(1,n2);

    Node n3 = new Node(4,5);
    l.insert(0,n3);

    l.print();
}