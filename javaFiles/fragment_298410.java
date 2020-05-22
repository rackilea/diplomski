String a = "abc";
String b = "abc";
System.out.println(a == b);    //prints false, a and b are 2 different objects
System.out.println(a.equals(b));    //prints true, the content of both string objects are equal;
b = "def";
System.out.println(a);    //prints "abc"
b = a;
System.out.println(a==b);    //prints true, a and b refer to the same String object
System.out.println(b);    //prints "abc";