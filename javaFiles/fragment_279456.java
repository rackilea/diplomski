class SpecialFoo extends Foo {
    private void doSomething(HashMap<String, Object> t) {
        // ...
    }

    public void whatever() {
        this.doSomething(this.getThings());
        this.doSomething(this.getMoreThings());
    }

    // ...more...
}