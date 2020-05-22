public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    keyboard.useDelimiter("\\n"); \\---------- this is what tells scanner to use new line char as delimiter

    while (true) {
        System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
        String diff = keyboard.next();

        String guess = "";
        String newGuess = "";
        String newWord = "loops";//RandomWord.newWord();

        int y = 0;
        int count = 0;
        for (int i = 0; i < newWord.length(); i++) {
            guess = newWord.replaceAll("[^#]", "-");
        }
        if ((diff.equalsIgnoreCase("e")) || (diff.equalsIgnoreCase("i")) || (diff.equalsIgnoreCase("h"))) {
            System.out.println("The secret word is:" + " " + newWord);
            System.out.println("The word is:" + " " + guess);

            System.out.println("Please enter the letter you want to guess");
            String letterInput = keyboard.next();

            System.out.println("Please enter the spaces you want to check (seperated by spaces)");
            String spaces = keyboard.next();

            for (String s : spaces.split("\\s")) {
                int x = Integer.valueOf(s);

                if (newWord.charAt(x) == letterInput.charAt(0)) {
                    System.out.println("Guess is correct for position " + x);
                    guess = guess.substring(0, x) + letterInput + guess.substring(x + 1, guess.length());
                    System.out.println(guess);
                }
            }
        }
    }
}