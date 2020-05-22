treeRoot.visit(new Visitor<Type>() {
    public boolean accept(Node<Type> node) {
        System.out.println("Visiting node "+node);
        return false;
    }
});