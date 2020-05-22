Multimap<String, String> myMultimap = ArrayListMultimap.create();
   // Adding some key/value

  myMultimap.put("STATUS1", "somePDF");
  myMultimap.put("STATUS1", "someDOC");
  myMultimap.put("STATUS1", "someXCL");   
  myMultimap.put("STATUS2","someFormat");

  // Getting the size
  int size = myMultimap.size();
  System.out.println(size);  // 4

  // Getting values
  Collection<string> stats1 = myMultimap.get("STATUS1");
  System.out.println(stats1); // [somePDF, someDOC, someXCL]