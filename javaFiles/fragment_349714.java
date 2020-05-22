// Initialize variables
String pre = "abc";
String post = ".txt";
Map<Double,String> m = new HashMap<Double,String>();

// Add data to your map
for (int a = 0; a < filename; a++) {
   m.put(similarityScore[a],pre + a + post + '\n');
}

// sort the map keyset and print out the sorted results
SortedSet<Double> set = new TreeSet<Double>(m.keySet());
for (int ii = set.size(); ii >= 0; --ii) {
   System.out.println(set.get(ii) + " " + m.get(d));
}