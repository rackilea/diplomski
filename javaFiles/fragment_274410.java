String s1 = "Mississippi";
String s2 = s1;
s1 = s1.replace('i', '!');
System.out.println(s1); // Prints "M!ss!ss!pp!"
System.out.println(s2); // Prints "Mississippi"
System.out.println(s1 == s2); // Prints "false" as s1 and s2 are two different objects