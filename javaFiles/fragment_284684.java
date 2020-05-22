ClassLoader classLoader = ClassLoader.getSystemClassLoader();
InputStream inputStream = classLoader.getResourceAsStream("words.txt");
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
List<String> wordList = new LinkedList<String>(); // You do not know word count, LinkedList is a better way.
String line = null;
while ((line = reader.readLine()) != null) {
  String[] words = line.toLowerCase().split("\\W+");
  wordList.addAll(Arrays.asList(words));
}
Set<String> wordSet = new HashSet<String>(wordList.size());
wordSet.addAll(wordList);


// then you can use the wordSet to check. 
// You shold convert the tokens to lower case.
String[] tokens = row.toLowerCase().split("\\W+");
wordSet.containsAll(Arrays.asList(tokens));