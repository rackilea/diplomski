function Foo() {
    var bar;

    this.setBar = function(b) {
        bar = b;
    };
    this.getBar = function() {
        return bar;
    };
}