Stream<Foo> = fooDBObjList.stream()
  .map(db -> {
    Foo foo = new Foo();
    foo.setBarId(db.Id);
    foo.setBarName(db.name);

    return foo;
  });