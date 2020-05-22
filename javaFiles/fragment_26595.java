String input = readFromUser();
String[] dictionary = new String[] { "Apple", "Cake" };
List<String> found = new ArrayList<>();
for (String word : dictionary) {
    int index = input.indexOf(word);
    if (index >= 0) {
        input = input.substring(0, index) + input.substring(index + word.length());
        found.add(word);
    }
}
System.out.println("Found " + found.size() + " words: " + found);