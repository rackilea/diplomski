e@Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        //because we know radiobutton3 is contains the right answer :)
        if (R.id.radioButton3 == checkedId)
        {
            ++score;
            //goes to the next question :)
          startActivity(new Intent(getBaseContext(), next_question_activity.class));

        }
        else
        {
            //goes to the next question without troubling the score :)
          startActivity(new Intent(getBaseContext(), next_question_activity.class));

        }

    }
});