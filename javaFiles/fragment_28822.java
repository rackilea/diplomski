String s1 = "test";
String s2 = "test";
String s3 = new String("test");


s1 == s2 // this is true because of string pool
s1 == s3 // this is false because of s3 is new instance