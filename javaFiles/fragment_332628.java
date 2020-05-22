i=0; //i should start from 0
while(inputFile.hasNext()){
    theWord = inputFile.next();
    ascending = true; //remember to reset ascending to be true as default
    i = 0; //reset i to 0 again
    if(theWord.length() >= 2){
        while(i < theWord.length() - 1){
            if(theWord.charAt(i) > theWord.charAt(i + 1)){
                 ascending = false;
                 break; //since we know that its not ascending, just move on to the next word
            }
            i++;
        }
        //if after the check ascending still true that means the word is ascending
        if(ascending==true){
            System.out.println("+ " + theWord);
            totalNum = totalNum + 1;
        }
    }
}