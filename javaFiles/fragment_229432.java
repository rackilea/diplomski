public static int score() {
    boolean qOneCheck = questionOneAnswer();
    int currentScore = 0;
    int oldScore = 0;
    int newScore = 0;
//      int random = randomGen();
    if (qOneCheck == true) {
//          currentScore = currentScore + random;
        currentScore = currentScore + 1;
        newScore = currentScore;
    } else {
        currentScore = oldScore;
        newScore = currentScore;
    }
    return newScore;
}