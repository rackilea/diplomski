if (SecretWord.indexOf(guess) >= 0) {
            int guessedIndex=SecretWord.indexOf(guess);

            ArrayList<Integer> indexes=getAllIndexes(guess,SecretWord);

            String outString="";

            for(int i=0;i<SecretWord.length();i++){
                if (indexes.contains(i)){ 
                    outString+=guess; //if its one of the guessed letters, put that in
                }else{
                    outString+=dash; //otherwise add a dash
                }

            }



            System.out.println(outString);
        } else {