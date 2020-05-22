void foo(List<String> stringList, Integer anInteger) {
  List<Object> objList = (List<Object>) stringList;
  objList.add(anInteger);  // Violation -- adding an object to a list of strings
                           // could cause someone getting a "String" to get an
                           // Integer stead
}