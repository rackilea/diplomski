List<Foo> myList = Arrays.asList(new Foo(1), new Foo(2), new Foo(3));

Foo[] fooArray = {new Foo(1), new Foo(2), new Foo(3)};

Gson g = new Gson();
System.out.println(g.toJson(myList));
System.out.println(g.toJson(fooArray));