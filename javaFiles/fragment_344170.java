if (currentQ.getANSWER().equals(AnswerString)) {
    // if conditions matches increase the int (score) by 1
    // and set the text of the score view
   // Intent intent = new Intent(this, QuestionActivity.class);
    //startActivity(intent);
    Toast.makeText(getApplicationContext(), "CORRECT!", Toast.LENGTH_SHORT).show();
    score++;
    scored.setText("Score:  " + score + " /100");
    txtQuestion.setAnimation(animFadein);
    txtQuestion.startAnimation(animFadein);


        if (score%5 == 1 ){
            helpbtn.setEnabled(false);
        } else {
            helpbtn.setEnabled(true);
        }


}