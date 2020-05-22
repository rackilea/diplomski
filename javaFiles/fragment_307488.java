String s1 = "Hello".concat("World");
String sx = "HelloWorld";
String s3 = new String(sx);
String s2 = s1.intern();
System.out.println(s1 == s2); //false
System.out.println(s1 == s3); //false
System.out.println(s2 == s3); //false
System.out.println(s1 == sx); //false
System.out.println(s2 == sx); //true