String expression = "((\\d[A-Z]|[A-Z]{2}|[A-Z]\\d),\\s)*(\\d[A-Z]|[A-Z]{2}|[A-Z]\\d),?$";

System.out.println("3F, 4B, AA, A4B".matches(expression)); // false
System.out.println("3F, 4B, 55, A4".matches(expression)); // false
System.out.println("3F, 4B, 5A, A4".matches(expression)); // true
System.out.println("3F, 4B,,".matches(expression)); // false
System.out.println("3F, 4B, AA, A".matches(expression)); // false
System.out.println("3F, 4B, AA,".matches(expression)); // true