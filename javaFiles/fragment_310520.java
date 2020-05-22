int getCorrectAnswersCount() {
    int count = 0;

    for (int i = 0; i < isCorrectAnswer.length; i++) {
        if (isCorrectAnswer[i]) {
            count++;
        }
    }

    return count;
}