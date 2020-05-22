List<Supplier<Common>> anArray = new ArrayList<>();

anArray.add(Foo::new);
anArray.add(Bar::new);

//or with lambdas:
anArray.add(() -> new Bar());