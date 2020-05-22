int pressedButtonIndex = btns.indexOf(view);
int correctAnswerIndex = questions[questionIndex].getCorrectAnswerIndex();

if (pressedButtonIndex == correctAnswerIndex) {
    // This means the user chose the correct answer
    if (questionIndex == 4) {
        // This is actually the last question! No need to display the next!
        return;
    }
    // load next question
    questionIndex++;

    someImageView.setImage(questions[questionIndex].getImageId());
    for (int i = 0 ; i < 4 ; i++) {
        btns[i].setText(questions[questionIndex].getAnswers()[i]);
    }
    // YAY! The next question is displayed.
} else {
    // User chose the wrong answer, do whatever you want here.
}