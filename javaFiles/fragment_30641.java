Node(String name, Node child) {
    this.name = name;
    if (child != null) {
        addChild(child);
    }
}