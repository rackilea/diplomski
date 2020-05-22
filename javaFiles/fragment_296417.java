void doSomething(e enumParam) {
    switch(enumParam) {
        case e.aaa: Foo.fooAaa(); break;
        case e.bbb: Foo.fooBbb(); break;
        default: ... // Throw some exception
    }
}