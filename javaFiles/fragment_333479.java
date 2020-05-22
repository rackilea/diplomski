private void showNextQuestionAndSaveAnswer(String answer)
{

    if (answer == null)
        return;

    if (questionArray.get(idx).getAnswer().equalsIgnoreCase(answer))
    {
        questionArray.get(idx).isCorrect = true;
    }

    idx++;

    if (idx < questionArray.size()) {
        fixIndexCountValue();
        Question questionClick = questionArray.get(idx);
        tv_question.setText(questionClick.getQuestion());
        bild.setImageResource(questionClick.getBildID());
        Collections.shuffle(buttons);
        buttons.get(0).setText(questionClick.getOptA());
        buttons.get(1).setText(questionClick.getOptB());
        buttons.get(2).setText(questionClick.getOptC());
        buttons.get(3).setText(questionClick.getAnswer());
    }
    else
    {
        Intent resultIntent = new Intent(MainActivity.this,ResultActivity.class);
        resultIntent.putExtra("list",questionArray);
        startActivity(resultIntent);
    }
}