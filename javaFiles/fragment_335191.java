class FirstTestVisitor implements ResolveVisitor {
    public void accept(Rectangle rect) {
        // logic for first test and if rect goes here
    }
    public void accept(GameObject obj) {
        // logic for first test and not rect goes here
    }
}