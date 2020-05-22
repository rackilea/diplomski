// All print 0
System.out.println(Foo.i);
System.out.println(Bar.i);
System.out.println(T.i);

new Bar(); // all print 1
System.out.println(Foo.i);
System.out.println(Bar.i);
System.out.println(T.i);

new T(); // all now print -1
System.out.println(Foo.i);
System.out.println(Bar.i);
System.out.println(T.i);