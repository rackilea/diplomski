String a="hello"+"world";  //line 1
  final String b="hello"; // now b is a literal
  final String c="world";// now c is a literal
  String d=b+c;
  String e="helloworld";
  System.out.println(e==a);
  System.out.println(a==d);// now it will be true because both are literals.