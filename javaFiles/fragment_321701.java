import java.util.Scanner;

public Hangman {

  private String secretWord;
  private String disguisedWord = "";
  private String result;
  private int guesses = 0;
  private int wrongGuess = 0;

  public void setSecretWord(String word) {
    secretWord = word;
  }

  public void setDisguisedWord() {
    for (int i = 0; i < secretWord.length(); i++) {
      disguisedWord += "*";
    }
  }

  public boolean guessLetter(char c) {
    for (int i = 0; i < disguisedWord.length(); i++) {
      if (c == secretWord.charAt(i) && disguisedWord.charAt(i) == '*') {
        disguisedWord = disguisedWord.substring(0, i) + c + disguisedWord.substring(i + 1);
        result = "Correct.";
        guesses++;
        return true;
      }
    }
    result = "Incorrect.";
    wrongGuess++;
    return false;
  }

  public String getDisguisedWord() {
    return disguisedWord;
  }

  public String getResult() {
    return result;
  }

  public int getGuesses() {
    return guesses;
  }

  public int getWrongGuess() {
    return wrongGuess;
  }

  public String getSecretWord() {
    return secretWord;
  }

}



public class Game {

  public static void main(String[] args) {

    String word1 = "html";
    String word2 = "css";
    String word3 = "java";

    Scanner kb = new Scanner(System.in);

    Hangman game = new Hangman();
    game.setSecretWord(word1);
    game.setDisguisedWord();

    System.out.println("Let's play a round of hangman.");
    System.out.println("We are playing hangman");

    while (true) {
      System.out.println("");
      System.out.println("The disguised word is " + game.getDisguisedWord());
      System.out.println("Guess a letter:");
      char guess = kb.next().charAt(0);
      boolean isFound = game.guessLetter(guess);
      if (isFound) {
        System.out.println(game.getResult() + " No. of guesses made is " + game.getGuesses() + " with " + game.getWrongGuess() + " wrong");
        if (game.getDisguisedWord().equals(game.getSecretWord())) {
          System.out.println("Good job, you found the secret word which is " + game.getSecretWord());
          break;
        }
      }
      else {
        System.out.println(game.getResult() + " No. of guesses made is " + game.getGuesses() + " with " + game.getWrongGuess() + " wrong");
      }
    }

  }

}