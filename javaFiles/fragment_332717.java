if (questionOptionsCorrect.length != questionOptions.length) {
    // Throw an exception here: the arrays must have the same length
    // for the code below to work
}
for (int i = 0 ; i != questionOptionsCorrect.length ; i++) {
    AnswerObjects ans = new AnswerObjects();
    ans.setAnswerText(questionOptions[i]);
    ans.setAnswerCorrect(questionOptionsCorrect[i]);
}