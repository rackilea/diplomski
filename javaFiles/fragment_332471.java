for (final Question questionData : questionSet) {
            tempQuestionSet.add(questionData);
            setUI(questionData);
            startTimer();
            break;
}
private void setUI(Question questionData) {
    question.setText(questionData.getQuestion());
    ch1.setText(questionData.getC1());
    ch2.setText(questionData.getC2());
    ch3.setText(questionData.getC3());

}

private void startTimer(){
    int interval = 10000;
    countDownTimer = new CountDownTimer(interval, 1000) {

        public void onTick(long millisUntilFinished) {
            time.setText("seconds remaining: "
                    + millisUntilFinished / 1000);
        }

        public void onFinish() {
            time.setText("done!");
            final Question question = getQuestionSet();
            if(question == null){
                countDownTimer.cancel();
            }else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        setUI(question);
                    }
                });
                countDownTimer.start();
            }

        }
    }.start();

}

private Question getQuestionSet(){
    Question newQuestion = null;
    for (final Question questionData : questionSet) {
        if(tempQuestionSet.contains(questionData)){         
        }
        else{
            tempQuestionSet.add(questionData);
            return questionData;
        }
    }
    return newQuestion;
}