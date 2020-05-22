String s1 = "abc";
  String s2 = "abc";
  // String s3 = s1+s2;
  String s3 = new StringBuilder().append(s1).append(s2).toString();
  // String s4 = s1+s2;
  String s4 = new StringBuilder().append(s1).append(s2).toString();

  //check s3 == s4
  System.out.println(s3==s4); // different objects.