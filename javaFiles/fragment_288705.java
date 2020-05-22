doAnswer(new Answer<YourReturnType>(){ 
    public YourReturnType answer(InvocationOnMock invocation) {
       YourParameterType parameter = (YourParameterType)invocation.getArguments()[0];
       // calculate your return value
       return yourCalculatedReturnValue;
    }
}).when(yourMock).theMethod(any(YourParameterType.class));