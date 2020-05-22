class Foo<BAR extends Bar> {
    void doFoo(BAR bar) {}
}

class ExtendedFoo extends Foo<ExtendedBar> {
    @Override
    void doFoo(ExtendedBar exBar) {}
}