private String hiddenWord = "banana";
private Set<Character> guesses = new HashSet<>();
private int misses;


public String applyGuess(char letterGuessed) {
    if (!guesses.contains(letterGuessed)) {
        guesses.add(letterGuessed);
        if (!hiddenWord.contains(Character.toString(letterGuessed))) {
            misses++;
        }
    }
    char[] progress = hiddenWord.toCharArray();
    for (int index = 0; index < hiddenWord.length(); index++) {
        if (!guesses.contains(hiddenWord.charAt(index))) {
            progress[index] = '*';
        }
    }
    return new String(progress);
}