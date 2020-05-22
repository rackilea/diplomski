Foo foo = new Foo();
  Foo anotherFoo = foo;

  anotherFoo.value = something; // both foo.value and anotherFoo.value will be changed to "something", because of the reference.

  anotherFoo = null; 
  // here you are expecting foo also to be null which is not correct.