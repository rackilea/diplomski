public String getRandomWord() {

    Hangman workingHangman = chooseDifficulty();
    int max = workingHangman.getWords().size();
    if (max == 0) {
         return "";
    }

    int randIndex = new Random().nextInt(max); // returns an integer between 0 and max-1

    return workingHangman.getWords().get(randIndex);
}