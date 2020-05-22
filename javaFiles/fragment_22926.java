private static String shuffle(String sentence) {
    String[] words = sentence.split("\\s+");
    StringBuilder builder = new StringBuilder();
    for (String word : words) {
        List<Character> letters = new ArrayList<Character>();
        for (char letter : word.toCharArray()) {
            letters.add(letter);
        }
        if (letters.size() > 2) {
            Collections.shuffle(letters.subList(1, letters.size() - 1));
        }
        for (char letter : letters) {
            builder.append(letter);
        }
        builder.append(" ");
    }
    return builder.toString();
}