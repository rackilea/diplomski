class Foo {
    Date dt;

    Foo() {
        this.dt = new Date();
    }
}

ArrayList<Foo> list = new ArrayList<Foo>();
list.add(new Foo());
list.clear();