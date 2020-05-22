when(doSomething.perform(firstParameter, any(Integer.class), 
             any(File.class)))
    .thenAnswer(new Answer<File>() {
          public File answer(InvocationOnMock invocation) throws Throwable {
        return invocation.getArgument(0);
    }
 };