Integer a = new Integer(5);
Integer b = new Integer(5);
System.out.println(a == b); // False, always

Integer c = 5;
Integer d = 5;
System.out.println(c == d); // True, always, due to caching of small boxed values