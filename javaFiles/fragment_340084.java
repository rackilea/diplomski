class Foo {
    Foo() {
        bar.addPropertyChangeListener(e -> {
             // Fetch and use new value of bar
        });
    }
}