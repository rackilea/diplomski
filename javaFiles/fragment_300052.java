String str1 = "string";
String str2 = new String("string");
String str3 = str2.intern();

str1 == str2 // false
str2 == str3 // false
str1 == str3 // true