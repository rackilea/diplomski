String text1 = "hello";
System.out.println(text1.length());

Object object = (Object) text1; // Or just Object object = text1;
// object.length() would be invalid...

String text2 = (String) object;
// text2.length() is valid again
System.out.println(text2.length());