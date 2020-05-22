input = input.replaceAll("[^äÄöÖüÜßa-zA-Z ]", ""); // <== Removed from here
String[] sentence = input.split(" ");

Map<String, Set<String>> anagrams = new HashMap<>();

for(int i = 0; i < sentence.length; i++){

        char[] charwords = sentence[i].toLowerCase().toCharArray(); // <== Added here

        Arrays.sort(charwords);

        String key = new String(charwords);

        Set<String> anagramSet = anagrams.get(key);
        if (anagramSet == null) {
          anagramSet = new HashSet<>();
          anagrams.put(key, anagramSet);
        }

   anagramSet.add(sentence[i]);

}