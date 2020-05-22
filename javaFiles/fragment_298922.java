Foo myFoo = new Foo();     // 1
callBar(myFoo);            // 2
myFoo.doSomething()        // 4

void callBar(Foo foo) {
    foo = new Foo();       // 3
}