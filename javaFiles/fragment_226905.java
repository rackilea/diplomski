int[] guesses = new int[4];
int guessFilling = 0;
[...]
@Override
public void guess() {
    int guess = rand.nextInt(maxGuess);
    System.out.println("Bot " + playerNum + " turn *" + guess + "*");
    if (guessFilling == guesses.length) {
        resizeGuesses();
    }
    guesses[guessFilling++] = guess;
}

private void resizeGuesses() {
    int[] newGuesses = new int[guesses.length > 0 ? 2 * guesses.length : 1];
    System.arraycopy(guesses, 0, newGuesses, 0, guesses.length);
    guesses = newGuesses;
}