String regex = "^ABC[0-9]{5}$";
String one = "ABC72961";
String two = "ABC2345";
String three = "AB12345";
String four = "ABABABAB";

System.out.println(one.matches(regex));      // true
System.out.println(two.matches(regex));      // false
System.out.println(three.matches(regex));    // false
System.out.println(four.matches(regex));     // false