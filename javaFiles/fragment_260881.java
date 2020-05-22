abstract class Foo<T> {

    List<T> list;

    // common logic
}

class A extends Foo<String> { }

class B extends Foo<Item> { }