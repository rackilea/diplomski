BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);
when(bufferedReader.readLine())
  .thenReturn("first line")
  .thenReturn("second line");

org.junit.Assert.when(new Client(bufferedReader).parseLine())
  .thenEquals(IsEqual.equalTo("first line"));