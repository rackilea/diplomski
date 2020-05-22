String s1 = "ZZ E5 - Pirates of carribean";
String s2 = "ZZ E5 : Pirates of carribean";

String canonicalS1 = s1.replaceAll("-", ":");
String canonicalS2 = s2.replaceAll("-", ":");

System.out.println(canonicalS1.equals(canonicalS2));