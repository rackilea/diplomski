CountDownTimer gameTimer, answerTimer;
boolean gameTimerIsRunning, answerTimerIsRunning;

public void startGame(){
    startGameTimer();
    startAnswerTimer();
}

public void startGameTimer(){
    gameTimer = new CountDownTimer(GAME_DURATION, TEXT_VIEW_UPDATE_RATE){

        @Override public void onTick(long millisUntilFinished) {
            updateGameTextView(millisUntilFinished);
        }

        @Override public void onFinish() {
            gameTimerIsRunning = false;
            if(answerTimerIsRunning) answerTimer.cancel(); 
            handleEndOfTheGame();
        }

    };
    gameTimerIsRunning = true;
    gameTimer.start();
}

public void startAnswerTimer(){
    if(answerTimer==null) {
        answerTimer = new CountDownTimer(TIME_FOR_AN_ANSWER, TEXT_VIEW_UPDATE_RATE) {

            @Override public void onTick(long millisUntilFinished) {
                updateAnswerTextView(millisUntilFinished);
            }

            @Override public void onFinish() {
                answerTimerIsRunning = false;

                if (gameTimerIsRunning) {
                    loadNewQuestion();
                    startAnswerTimer();
                }
        };
    }
    answerTimerIsRunning = true;
    answerTimer.start();
}