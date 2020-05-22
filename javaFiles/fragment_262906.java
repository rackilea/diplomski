if (SecretWord.indexOf(guess) >= 0) {
            int guessedIndex=SecretWord.indexOf(guess);

            String outString="";

            for(int i=0;i<guessedIndex;i++){
                outString+=dash; //repeat dash until we get to the correctly guessed letter
            }

            outString+=guess; //put the letter in

            for(int i=guessedIndex;i<SecretWord.length();i++){
                outString+=dash; //repeat dash until we get to end of the word
            }

            System.out.println(outString);
        } else {