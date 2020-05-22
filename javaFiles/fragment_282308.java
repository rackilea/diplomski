List<Consumer<Foo>> list = new ArrayList<>();
    list.add((foo) -> foo.method1("a"));
    list.add((foo) -> foo.method2(new ArrayList<>()));
    list.add((foo) -> foo.method3(new HashMap<>(), "Other stuff"));

    Foo foo = new Foo();
    list.forEach(fooConsumer -> fooConsumer.accept(foo));