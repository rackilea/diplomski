// will return true four times, and then false for all calls afterwards
when(mockFizzChecker.hasMoreBuzz()).thenReturn(true, true, true, true, false);
when(mockFizzChecker.hasMoreBuzz())
    .thenReturn(true)
    .thenReturn(true)
    .thenReturn(true)
    .thenReturn(true)
    .thenReturn(false);
// you can also switch actions like this:
when(someOtherMock.someMethodCall())
    .thenReturn(1, 2)
    .thenThrow(new RuntimeException());