correctAnswerRadios = new ArrayList<>();
wrongAnswersRadios = new ArrayList<>();

radioGroup.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        for (int j = 0; j < checkedRadioButton.length; j++) {            
            correctAnswerRadios.remove(checkedRadioButton[j]);
            wrongAnswersRadios.remove(checkedRadioButton[j]);
        }
        for (int j = 0; j < checkedRadioButton.length; j++) {
            if (checkedRadioButton[j].isChecked() & CorrectAnswer == 1) {
                correctAnswerRadios.add(checkedRadioButton[j]);
            } else {
                wrongAnswersRadios.add(checkedRadioButton[j]);
            }
        }
    }
});