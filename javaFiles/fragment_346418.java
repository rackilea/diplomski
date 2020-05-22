private boolean traverse(Visitor visitor) {
    while (/*still traversing*/) {
        if (!visitor.visitNode(thisNode)) {
            return false;
        }
        /*determine next node to visit and whether done*/
    }
    return true;
}