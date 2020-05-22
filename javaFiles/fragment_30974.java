public static void main(String[] args) {
    Tree t;
    t.connectParentToChild("A", "D");
    t.connectParentToChild("A", "B");
    t.connectParentToChild("A", "C");
    t.connectParentToChild("B", "C");
    t.connectParentToChild("B", "H");
    t.connectParentToChild("B", "F");
    t.connectParentToChild("B", "E");
    //Set all other nodes
    t.getValue("H", "L");
}