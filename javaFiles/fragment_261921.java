public List<MyObject> getChildren() {
    return Collections.unmodifiableList(children);
}

public boolean hasChildren(MyObject... children) {
    return parent.getChildren().containsAll(Arrays.asList(children)); // 
}