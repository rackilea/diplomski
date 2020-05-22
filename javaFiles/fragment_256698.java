public static void main(String... args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    five.setNodes(four, null);
    four.setNodes(three, five);
    three.setNodes(two, four);
    two.setNodes(one, three);
    one.setNodes(null, two);

    System.out.println("before reversing...");
    System.out.println(one);

    System.out.println("After reversing...");
    one = reverse(one, three);
    System.out.println(one);
}