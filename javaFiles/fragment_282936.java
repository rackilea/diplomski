next = (Button)findViewById(R.id.next);
        next.setVisibility(View.GONE);
        next.setOnClickListener(nextListener);

private View.OnClickListener nextListener = new View.OnClickListener() {
    public void onClick(View v) {
        setAnswer();
        if (quesIndex != QuizFunActivity.getQuesList().length()-1) {
            quesIndex++;
            showQuestion(quesIndex,review);
        }
        else {
            Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
            myIntent.putExtra("key", value); //Optional parameters
            CurrentActivity.this.startActivity(myIntent);
        }
        if (quesIndex == QuizFunActivity.getQuesList().length()-1)
            next.setText("Finish");
    }
};