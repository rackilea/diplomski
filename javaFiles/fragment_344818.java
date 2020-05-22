String str = "abc-d-abc";
str = str.replaceAll("abc", "\\$");
System.out.println(str);

String str1 = "abc-d-abc";
str1 = str1.replaceAll("abc", "\\\\");
System.out.println(str1);