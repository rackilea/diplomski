private static String scrambleWord(String word) {
    List<Character> characters = new ArrayList<>();
    for (char ch : word.toCharArray()) {
        characters.add(ch);
    }
    Collections.shuffle(characters);
    StringBuilder sb = new StringBuilder();
    for (char ch : characters) {
        sb.append(ch);
    }
    return sb.toString();
}