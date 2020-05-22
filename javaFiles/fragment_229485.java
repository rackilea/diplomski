final Foo foo = new Foo();
final Bar bar = new Bar();
Service.pendingServices$.MODULE$.update("baz", foo, ClassTag$.MODULE$.apply(Foo.class));
Service.pendingServices$.MODULE$.update("baz", bar, ClassTag$.MODULE$.apply(Bar.class));

System.out.println(Service.pendingServices$.MODULE$.<Foo>apply("baz", ClassTag$.MODULE$.apply(Foo.class))); // Foo()
System.out.println(Service.pendingServices$.MODULE$.<Bar>apply("baz", ClassTag$.MODULE$.apply(Bar.class))); // Bar()