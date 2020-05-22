interface Foo {}
interface Bar extends Foo {}
class Baz implements Foo {}

public static <T extends Foo> void f(T t) {

}

Bar bar = new Bar() {};
f(bar); // compiles!
Baz baz = new Baz();
f(baz); // compiles!