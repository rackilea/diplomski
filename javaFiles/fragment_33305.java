String string = "I am really busy right now";
Map<Character, Integer> characterCounts = new HashMap<Character, Integer>();
for (char character : string.toCharArray()) {
    Integer characterCount = characterCounts.get(character);
    if (characterCount == null) {
        characterCount = 0;
    }
    characterCounts.put(character, characterCount + 1);
}