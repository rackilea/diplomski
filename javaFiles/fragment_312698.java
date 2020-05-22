Foo f = new Foo();
    Foo.ChildClass fc = f.new ChildClass();
    f.doSomething();
    fc.anotherAction();

    Bar b = new Bar();
    Bar.ChildClass bc = b.new ChildClass();
    b.doSomething();
    bc.anotherAction();