// Setup expectations
when(object.method()).thenReturn(value);
when(object.method()).thenThrow(exception);
doThrow(exception).when(object.voidMethod());


// verify things
verify(object, times(2)).method();
verify(object, times(1)).voidMethod();