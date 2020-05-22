private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
private static final Random RAND = new Random();

private static char getRandomLetter() {
    int randomIndex = RAND.nextInt(LETTERS.length);
    return LETTERS[randomIndex];
}