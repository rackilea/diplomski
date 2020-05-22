TestMock mock = Mockito.mock(TestMock.class);
mock.doIt("1");
mock.doIt("2");

ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
verify(mock, times(2)).doIt(argument.capture()); // verify that it was call 2 times and capture the values given

System.out.println(argument.getAllValues());