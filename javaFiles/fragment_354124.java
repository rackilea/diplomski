class Foo<TSelf extends Foo> {
    Class<TSelf> selfClass;

    Foo(Class<TSelf> selfClass) {
        if (!this.getClass().equals(selfClass)) 
            throw new IllegalArgumentException();
        this.selfClass = selfClass;
    }

    TSelf returnThis() {
        return selfClass.cast(this);
    }
}

class Bar extends Foo<Baz> {
    Bar() {
        super(Baz.class);
    }
}