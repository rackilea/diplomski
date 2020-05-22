List a = new ArrayList();
  a.add("foo");
  a.add("bar");
  System.out.println(a); // prints [foo, bar]

  Object[] myArray = a.toArray();
  for (int i = 0; i < myArray.length; i++) {
   System.out.println(myArray[i]); // prints 'foo' and 'bar'
  }