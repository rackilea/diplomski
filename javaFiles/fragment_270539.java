World  mockWorld = mock(World.class); 
doAnswer(new Answer<Void>() {
    public Void answer(InvocationOnMock invocation) {
      Object[] args = invocation.getArguments();
      System.out.println("called with arguments: " + Arrays.toString(args));
      return null;
    }
}).when(mockWorld).setState(anyString());