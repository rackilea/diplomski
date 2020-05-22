package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();

        foo.fooOne(bar);
        bar.barOne(foo);
    }
}