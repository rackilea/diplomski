String myWord;

    public static void main(String[] args) {

        AssignmenTwo a2 = new AssignmenTwo();
        a2.runGame();
        //
        // indexOfGuessed(guess,myWord,hiddenWord);
        // printArr(hiddenWord);
    }

    public void runGame(){
        welcomeMessage();
        myWord = randomizeWord();
        char[] hiddenWord = hideWord(myWord);
        printArr(hiddenWord);
        char guess = userLine();
        game(guess, myWord);
    }

    public void game(char userGuess, String word) {
        int attempts = 10;
        while (attempts > 0) {
            round();
            for (int i = 0; i < word.length(); i++) {
                if (userGuess != word.charAt(i)) {
                    attempts--;
                    System.out.println("You have" + attempts + "attempts. Try again!");
                }
            }
        }
    }

    public void round() {

        char[] hiddenWord = hideWord(myWord);
        printArr(hiddenWord);
        char guess = userLine();

        indexOfGuessed(guess, myWord, hiddenWord);
        printArr(hiddenWord);
        return;
    }  ...