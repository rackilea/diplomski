Set<Integer> s1=new HashSet<Integer>();
  s1.add(1);s1.add(4);s1.add(5);

  Set<Integer> s2=new HashSet<Integer>();
  s2.add(2);s2.add(3);s2.add(6);

  Set<Integer> s3=new HashSet<Integer>();
  s3.add(7);s3.add(8);s3.add(8);

  Set<List<Integer>> set=Sets.cartesianProduct(s1,s2,s3);
  //Give type safety warning
  for(List<Integer> l:set){
      System.out.println(l);
  }