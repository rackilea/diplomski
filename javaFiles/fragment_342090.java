int nr1 = 1;
int nr2  = 1;
if(nr1 == nr2) {...} //true -> int is a native type

String str1 = "test";
String str2 = "test";
if(str1 == str2) {...} //false -> Same content but not same objects
if(str1.equals(str2)) {...} //true -> Same content, different objects