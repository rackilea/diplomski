private static boolean onlyOneIsNull(IntNode node1, IntNode node2) {
    return (node1 != null && node2 == null)
           || (node1 == null && node2 != null);
}

private static int stickCt(IntNode T) {
    //easiest case
    if(T==null) {
        return 0;
    }
    //evaluating if I'm a stick
    int num = 0;
    if (onlyOneIsNull(T.getLeft(), T.getRight())) {
        num = 1;
    }
    //stickCt already takes care of null nodes, no need to add a null validation for nodes
    //need to return the number of sticks from left node and right node
    return stickCt(T.getLeft()) + stickCt(T.getRight()) + num;
}