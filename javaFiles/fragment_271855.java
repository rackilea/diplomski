OnClickListener answerClick = new OnClickListener() {
    public void onClick(View v) {
        int index = (Integer) v.getTag();
        if(answer == index) {
            correctAnswers++;
            queries.get(i).setSelectedAnswer(index);
            queries.get(i).setCorrectness(true);
        } else {
            wrongAnswers++;
            queries.get(i).setCorrectness(false);
        }
        nextQuestion();
    }
};

answer1 = (Button)findViewById(R.id.answer1);
answer1.setOnClickListener(answerClick);
answer1.setTag(0);

answer2 = (Button)findViewById(R.id.answer2);
answer2.setOnClickListener(answerClick);
answer2.setTag(1);

//etc