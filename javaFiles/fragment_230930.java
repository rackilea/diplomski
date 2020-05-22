String regex="(\\(\\d{3}\\)|\\d{3})([.-])\\d{3}\\2\\d{4}";

System.out.println("(123).234.4567".matches(regex)); // true
System.out.println("(123)-234-4567".matches(regex)); // true
System.out.println("123.234.4567".matches(regex));   // true
System.out.println("123-456-4567".matches(regex));   // true

System.out.println("(123)-234.4567".matches(regex)); // false
System.out.println("(123-234-4567".matches(regex));  // false
System.out.println("123.234-4567".matches(regex));   // false
System.out.println("123-456.4567".matches(regex));   // false