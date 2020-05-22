when(mock.foo()).thenThrow(new RuntimeException());

//Impossible: the exception-stubbed foo() method is called so RuntimeException is thrown.
when(mock.foo()).thenReturn("bar");

//You have to use doReturn() for stubbing:
doReturn("bar").when(mock).foo();