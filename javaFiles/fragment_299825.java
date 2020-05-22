String a = new String("test");
String b = new String("test");
String x = "test";
String y = "test";
// Deliberately using == rather than equals, to check reference equality
System.out.println(a == b); // false
System.out.println(a == x); // false
System.out.println(x == y); // true