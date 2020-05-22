void resolve(GameObject obj) {
    if (first test) {
        obj.accept(new FirstTestVisitor());
    } else if (second test) {
        obj.accept(new SecondTestVistor());
    } else {
        obj.accept(new DefaultVisitor());
    }
}