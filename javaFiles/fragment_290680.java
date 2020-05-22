for (Question question : list) {
    if (question instanceof MultipleChoice) {
        MultipleChoice multipleChoice = (MultipleChoice) question;
        multipleChoice.doSomething();

    } else if (question instanceof TrueAndFalse) {
        TrueAndFalse trueAndFalse = (TrueAndFalse) question;
        trueAndFalse.doSomethingElse();

    }
}