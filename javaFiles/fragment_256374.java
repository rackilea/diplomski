String s1 = "abc";
  String s2 = "abc";
  String s3 = (s1+s2).intern(); // use the string literal pool
  String s4 = (s1+s2).intern();

  //check s1 == s2
  System.out.println(s1==s2);

  //check s3 == s4
  System.out.println(s3==s4); // is now true.