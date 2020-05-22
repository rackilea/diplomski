public void getAnswer(String AnswerString) {
    // ...
    if (++qid < 20) { // - add increment here
        currentQ = mQuestionList.get(qid);
        setQuestionView();
    } else {
        // ...
    }
}

private void setQuestionView() {
    // ...
    // qid++; - remove increment here
}