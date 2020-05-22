String input = "manifest";
Matcher m1 = Pattern.compile("ni").matcher(input);
System.out.println(m1.matches()); // false
System.out.println(m1.find()); // true
Matcher m2 = Pattern.compile(".*ni.*").matcher(input);
System.out.println(m2.matches()); // true
System.out.println(m2.find()); // false