PrintWriter mockWriter = Mockito.mock(PrintWriter.class);
Object mockA = Mockito.mock(Object.class);
Mockito.when(mockA.getWriter()).thenReturn(mockWriter);
ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
verify(mockWriter).append(argument.capture());
String result = argument.getValue();