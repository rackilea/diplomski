public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    // References for TrackerNode objects
    TrackerNode headNode = null, currNode = null, lastNode = null;

    // Scan the number of nodes
    int i = scnr.nextInt();

    // in data and insert into the linked list
    for (int k = 0; k < i; k++) {
        String name = scnr.next();
        int age = scnr.nextInt();
        scnr.nextLine();
        if (lastNode != null) {
            currNode = new TrackerNode(name, age);
            lastNode.insertAfter(currNode);
        } else {
            currNode = headNode = new TrackerNode(name, age);
        }
        lastNode = currNode;
    }

    // Print linked list
    currNode = headNode;
    while (currNode != null) {
        System.out.println(currNode);
        currNode = currNode.getNext();
    }
}