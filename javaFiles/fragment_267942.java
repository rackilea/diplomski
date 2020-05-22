String str1 = "Foo value 1.1.1".replaceAll("(?<=value\\s)[\\w\\.?]+", "AAA");
String str2 = "Foo value 1.1".replaceAll("(?<=value\\s)[\\w\\.?]+", "BBB");
String str3 = "Foo value Stackoverflow".replaceAll("(?<=value\\s)[\\w\\.?]+", "CCC");
System.out.println(str1);//output: Foo value AAA
System.out.println(str2);//output: Foo value BBB
System.out.println(str3);//output: Foo value CCC