static Set<String> names = new TreeSet<String>();

 public static void addToNames(String[] manyNames) {
   for(String name:manyNames)
     names.add(name);
 }