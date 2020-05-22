Random r = new Random();

List<Map.Entry<String, String>> allPairs = new ArrayList<>(dictionary.entrySet());
// list will be filled with content from this set          ^^^^^^^^^^^^^^^^^^^^^ 
int randomIndex = r.nextInt(allPairs.size());
Map.Entry<String, String> randomEntry = allPairs.get(randomIndex);
System.out.println(randomEntry.getKey());
System.out.println(randomEntry.getValue());