String s = "123456789012";
String s1 = s.substring(0, 4);
String s2 = s.substring(4, 8);
String s3 = s.substring(8, 12);

String dashedString = s1 + "-" + s2 + "-" + s3;
//String.format is extremely slow. Just concatenate them, as above.