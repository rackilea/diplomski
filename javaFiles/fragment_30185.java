public Move getMove()
    {
        System.out.println("Make you choice: Rock, paper or scissors");

        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);  //<-- Fix the camelCase
        // char firstLetter = 0;                  //<-- Remove this line
        if (firstLetter == 'R' || firstLetter == 'P'
                || firstLetter == 'S') {
            switch (firstLetter) {
            case 'R':
                return Move.ROCK;
            case 'P':
                return Move.PAPER;
            case 'S':
                return Move.SCISSORS;
            }
        }
        return getMove();
    }