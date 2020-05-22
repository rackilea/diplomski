while(getGuessLeft()>0) {
    getLettersGuesed().add(letter);
    if (!randomPirateWord.contains(letter+"")) {
        setGuessLeft(getGuessLeft() - 1);
        System.out.println("You lost a life, now have " + getGuessLeft());
    }
    for(int i1 = 0; i1 <getRandomPirateWord().length(); i1++) {
        if(words[i1] == letter) words2[i1] = letter;
    }
    for(int i1 = 0; i1 < getRandomPirateWord().length(); i1++){
        System.out.print(words2[i1]);
    }
}