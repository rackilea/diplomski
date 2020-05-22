Test test = new Test();
// The generic type is erased here...
List a = test.foo1.bar;
// ...and a cast is added here
String b = (String) a.get(0);
Integer b = (Integer) test.foo2.a;