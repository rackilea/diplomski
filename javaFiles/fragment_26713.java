interface FooImplMap {
    void put(String key, Foo value);
    <F extends Foo> F get(String key);
}

class Bar implements Foo {}
class Biz implements Foo {}