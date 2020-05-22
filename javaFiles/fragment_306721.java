class Foo{
    Foo(Object o){

    }
}

class FooBar extends Foo {
    FooBar(Object o, Boolean a){
        this(o,a,this);
    }
    FooBar(Object o, Boolean a, FooBar fb){
        super(o);           
    }
}