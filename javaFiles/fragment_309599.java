String a = "abc";
String b = "def";
String c = a;

a = a + b;

System.out.println(a); // will print "abcdef".
System.out.println(b); // will print "def".
System.out.println(c); // will print "abc".

// Now we compare references, in java == operator compare references, not the content of objects.

System.out.println(a == a); // Will print true
System.out.println(a == c); // Will print false, objects are not the same!

a = c;

System.out.println(a == c); // Will print true, now a and b points on the same instance.