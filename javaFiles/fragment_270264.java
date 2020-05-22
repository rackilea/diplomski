public void addAnswer(InfoRepository repository, Integer questionIndex, Info answer) {
    Info question = repository.getInfoById(new InfoId(getId(), questionIndex));

    if(question.getInfoCategory().equals(InfoCategory.ANSWER))
        throw new RuntimeException("Is not a question");

    if(question.getAnswer() != null)
        throw new RuntimeException("You can not post a new answer");

    answer.setInfoCategory(InfoCategory.ANSWER);
    answer.setInfoId(new InfoId(getId(), getInfoList().size()));

    getInfoList().add(answer);

    // Added in order to set up AnswerIndex property
    question.setAnswerIndex(answer.getInfoId().getIndex());
}