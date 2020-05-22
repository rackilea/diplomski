//case 1
public class Foo<T> {
    //...
}

//case 2
public class Bar<E> extends Foo<E> {
    //...
}

//case 3
public class Baz extends Foo<String> {
    //...
}