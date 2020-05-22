public void disp() {
    Node current = first; //Start with "first"
    while (current != null) {
        System.out.println(current.data);
        current = current.next; //Move "current" to next node
    }
}