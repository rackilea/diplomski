Foo foo = new Foo();
Bar bar1 = new Bar("bar1");
Bar bar2 = new Bar("bar2");
foo.addBar1(bar1);
foo.addBar2(bar2);
bar1.foos1.add(foo);
bar2.foos2.add(foo);
Ebean.save(foo);