class Foo {
    Bar bar;

    Bar getBar() {
        return this.bar;
    }

    void setBar(Bar bar) {
        this.bar = bar;
    }

    void outerVoid() {
        this.bar.innerVoid();
    }
}