class Parent {
    private ParentEntity inner;
    public Parent(ParentEntity entity) {
        inner = entity;
        // initialize children or have getChildren to dynamically create it
        // from inner.childre
        ...
    }
...
}