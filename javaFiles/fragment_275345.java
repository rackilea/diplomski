Enumeration names;
  names = balance.keys();

  while(names.hasMoreElements()) {
     string curr = (String) names.nextElement();
     System.out.println(curr + ": " +
     wordsAccur.get(curr));
  }