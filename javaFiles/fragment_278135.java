public void addQuiz() { 
    for(int i = 0; i < 5; i++){ //Loops through and adds 5 scores
    int score = randomNumbers.nextInt(101);
    scores[i] = score;
    }
}