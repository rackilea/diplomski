String s1 = "foo";
String s2 = new String("foo");
String s3 = s2;

System.out.println(s1 == s2); // false
System.out.println(s1 == s3); // false
System.out.println(s2 == s3); // true

System.out.println(s1.equals(s2)); // true
System.out.println(s1.equals(s3)); // true
System.out.println(s2.equals(s3)); // true