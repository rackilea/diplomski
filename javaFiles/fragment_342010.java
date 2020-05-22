private void onClickContent(View view)
{
    Context context = getApplicationContext();
    final Button button = (Button) view;
    String answer = button.getText().toString();

    if (answer.equalsIgnoreCase(correctAnswer))
    {
        button.setTextColor(Color.GREEN);

        if (index == maxIndex)
        {
            appPreferences.editPreferences(context, Globals.PREFERENCE_KEY + subjectId, true);

            playSound(Globals.SOUND_QUIZ_COMPLETED);

            Toast toast = Toast.makeText(context, "Quiz \"" + subject.getSubjectName() + "\" finished",Toast.LENGTH_LONG);
            toast.show();
            finish();
        } else
        {
            playSound(Globals.SOUND_CORRECT_ANSER);

            // Go to next question
            index++;
            // Go to next question after 1000ms
            view.postDelayed(new Runnable() {
                public void run() {
                    setQuestionsAndAnswers(index);
                }
            }, 1000); //here delays 1000ms
        }

    } 
    ...
}