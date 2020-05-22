Mockito.when(reader.document(anyInt())).thenAnswer(new Answer() {
 public Object answer(InvocationOnMock invocation) {
     Object[] args = invocation.getArguments();
     Object mock = invocation.getMock();
     return document(fakeIndex((int)(Integer)args[0]));
     }
 });