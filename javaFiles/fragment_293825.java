String first  = "ABCxyABC"; 
String second = "ABCzzCDE"; 
String third  = "12341234zAE";

Pattern p = Pattern.compile("(.+)\\1");

System.out.println(p.matcher(first).find());  //false
System.out.println(p.matcher(second).find()); //true
System.out.println(p.matcher(third).find());  //true