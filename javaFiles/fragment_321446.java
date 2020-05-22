AtomicInteger counter = new AtomicInteger();
when(accessDao.calculateWork(user)).thenAnswer(new Answer() {
  Object answer(InvocationOnMock invocation) {
    if (counter.getAndIncrement() == 0) return someValue;
    return anotherValue;
  }
});