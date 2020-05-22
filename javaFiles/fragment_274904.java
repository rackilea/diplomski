List<String> results = new ArrayList<String>();
results.add(""); // Seed it for the base case n=0
for (int i = 0; i < n; i ++) {
    List<String> previousResults = results;
    results = new ArrayList<String>();
    for (String s : options) {
       for (String base : previousResults) {
           results.add(s + base);
       }
    }
}
return results;