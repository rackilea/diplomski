List<Foo> oldList = // ...
List<Foo> newList = new ArrayList<>();
for (Foo foo : oldList) {
  Foo newFoo = new Foo(foo); // copy constructor
  newList.add(newFoo);
}