final String s1 = "abc";
  final String s2 = "abc";
  String s3 = s1+s2; // compiler replaces with "abcabc"
  String s4 = s1+s2; // compiler replaces with "abcabc"

  //check s1 == s2
  System.out.println(s1==s2);

  //check s3 == s4
  System.out.println(s3==s4); // is now true.