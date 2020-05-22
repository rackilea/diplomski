String [] GuessedWordSoFar = new String[wordToGuess.length()];
do {
System.out.println("Choose a letter: ");
firstGuess = keyboard.next();

char[] wordToGuessInCharArray = wordToGuess.toCharArray();

if((new String(wordToGuessInCharArray).contains(firstGuess))){
    int index = -1;
    char c = firstGuess.charAt(0);
    for(int z = 0; (z <wordToGuessInCharArray.length)&& 
       (index == -1); z++){ 

        if( wordToGuessInCharArray[z] == c) {
            index = z;
            System.out.println("Correct");
            GuessedWordSoFar[index] = firstGuess;
        }
    }
    System.out.println(Arrays.asList(GuessedWordSoFar));
}