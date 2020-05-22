Object possibleAnswers [] = {currentQuestion.getOptA(), currentQuestion.getOptB(), currentQuestion.getOptC(), currentQuestion.getOptD()};
Button buttons [] = {buttonA, buttonB, buttonC, buttonD};

for (int i = 0; i < possibleAnswers.lenght; i++) {
    if (currentQuestion.getAnswer().equals(possibleAnswers[i]) {
        buttons[i].setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGreen));
        break;
    }
}