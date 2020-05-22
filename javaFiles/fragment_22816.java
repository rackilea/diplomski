function Foo() {
    var bar;

    function Foo_setBar(b) {
        bar = b;
    }
    function Foo_getBar() {
        return bar;
    }

    this.setBar = Foo_setBar;
    this.getBar = Foo_getBar;
}