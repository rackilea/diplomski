String str1 = "D:/Views/me/a.b";
String str2 = "D:/Views/me/a";
if (str1.startsWith(str2 + ".") || str1.startsWith(str2 + "/")) {
    System.out.println("Yes it is");
}
str1 = "D:/Views/me/a/c/d";
str2 = "D:/Views/me/a";
if (str1.startsWith(str2 + ".") || str1.startsWith(str2 + "/")) {
     System.out.println("Yes it is");
}
Output:
Yes it is
Yes it is