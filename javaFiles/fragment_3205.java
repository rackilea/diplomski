buttonCheckAnswer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, AnswerActivity.class);

        boolean isAllAnswered = allAnswersChecked();
        Toast.makeText(getApplicationContext(), "isAllAnswered value is: " + isAllAnswered, Toast.LENGTH_SHORT).show();  

        if (isAllAnswered)
        {
            boolean isGoodAnswer = checkAnswers();
            Toast.makeText(getApplicationContext(), "isGoodAnswer value is: " + isGoodAnswer, Toast.LENGTH_SHORT).show();  

            if (isGoodAnswer)
                intent.putExtra("KEY_ANSWER", "Good Answer");
            else
                intent.putExtra("KEY_ANSWER", "Wrong Answer");
        }
        else
            intent.putExtra("KEY_ANSWER", "You haven't checked all answers");

        startActivity(intent);
    }
});