class SpecialFoo extends Foo {
    private void doSomething(Map<String, Object> t) { // <== Changed
        // ...
    }

    public void whatever() {
        this.doSomething(this.getThings());
        this.doSomething(this.getMoreThings());
    }
}