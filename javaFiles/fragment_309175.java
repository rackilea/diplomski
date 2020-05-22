int score = 0;
btn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
       score = score + 1;
       tv_score.setText("Score: " + score);

       if(score == 10){
            tv_nextStep.setText("Next step: " + 10);
       }
       if(score == 20){
            tv_nextStep.setText("Next step: " + 30);
       }
    }
});