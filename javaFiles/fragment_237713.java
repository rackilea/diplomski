guess = Keyboard.readChar();
int count = 0;
for (char c : in.toCharArray()) {
    if (c == guess) {
        count++;
    }
}
if (count > 0) {
  System.out.println("You have guessed a correct letter!");
  correctGuess += count;
} else {
  System.out.println("Sorry! That is an inncorrect guess! Please try again!");
}
guessCount++;