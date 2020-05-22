class Foo {
    Date dt;

    Foo() {
        dt = new Date();
    }
}

ArrayList<Foo> list = new ArrayList<Foo>();
Foo f = new Foo();
list.add(f);
list.clear();