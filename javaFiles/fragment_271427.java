private OnClickListener hintOnClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
        G.numOfGuesses--;

        // Since you shuffled the 'allAnswers' before displaying to the screen, 
        // we can just pick the first 2 answers from wrongAnswers list
        // and it will appear to be random to the user.
        for (int i=0; i < buttons.length; i++) {
            String buttonText = buttons[i].getText().toString();

            if (buttonText.equals(wrongAnswers.get(0))
                || buttonText.equals(wrongAnswers.get(1))) {
               buttons[i].setVisibility(View.INVISIBLE);
            }
        }
    }
};