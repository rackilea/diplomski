doAnswer(new Answer<Boolean>() {
  int calledCnt = 0;

  @Object public Boolean answer(InvocationOnMock invocation) {
    if (calledCnt == 0) {
      calledCnt += 1;
      throw new InternalServerErrorException("test");
    }
    return false;
  }
}).when(...);