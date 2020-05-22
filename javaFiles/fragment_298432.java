final Answer answer1 = ...;
final Answer answer2 = ...;
Answer compositeAnswer = new Answer() {
  public Void answer(InvocationOnMock invocation) throws Throwable {
    answer1.answer(invocation);
    answer2.answer(invocation);
    return null;
  }
};