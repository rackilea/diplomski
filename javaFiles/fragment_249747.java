Mockito.when(test)
       .getResult(Mockito.eq(Argument.VALUE))
       .thenAnswer(
          new Answer<Result>() {
              Result answer(InvocationOnMock invocation) {
                  return makeRes1();
              }
        });