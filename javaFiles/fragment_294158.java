// method signature changed
public void inOrder(Node focusNode, ArrayList vals) {

    /* ArrayList<Integer> tempList = new ArrayList<Integer>(); */

    if ( focusNode != null) {
        // args changed here
        inOrder(focusNode.getLeftNode(), vals);
        // adding node to array list rather than dumping to console
        vals.add(focusNode);
    /*  tempList.add(focusNode.getElement()); */
        inOrder(focusNode.getRightNode());
}