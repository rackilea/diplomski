//first line validator:
String reg1 = "S:[A-Z01e]";
//next lines validator:
String reg2 = "V:[A-Z01e]?[A-Z01e]?[A-Z01e]";

//examples/test cases:
System.out.println("S:1".matches(reg1));
System.out.println("S:3".matches(reg1));
System.out.println("S:11".matches(reg1));

System.out.println("V:1e0".matches(reg2));
System.out.println("V:1e01".matches(reg2));
System.out.println("V:1e3".matches(reg2));