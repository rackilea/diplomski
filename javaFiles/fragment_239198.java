public boolean insert(int index, Node element) {
//if (index < 0 || index > count)
if (index < 0 || index > count + 1) return false;
if(head == null) {
    head = element;
    return true;
}
if (index == 0) {
    //Node newNode = new Node();
    //newNode.setExponent(element);
    count++;
    element.setLink(head);
    //newNode.setLink(head);
    head = element;
    //head = newNode;
    return true;
}
    Node walker = head;
    //for (int i = 0; i < (index - 1); i++)
    for (int i = 1; i < index; i++) {
        walker = walker.getLink();
    }
    //Node newNode = new Node();
    //newNode.setExponent(element);
    element.setLink(walker.getLink());
    //newNode.setLink(walker.getLink());
    //walker.setLink(newNode);
    walker.setLink(element);
    count++;
    return true;
}