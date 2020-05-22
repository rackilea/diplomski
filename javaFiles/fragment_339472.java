@Test
public void aListOfSizeOneShouldPrintTheElementWithinBrackets() {
    /* Setup */
    final StringBuffer printStream = new StringBuffer();
    PrintStream mockedOut = mock(PrintStream.class);
    Mockito.doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            printStream.append(invocation.getArguments()[0].toString());
            return null;
        }
    }).when(mockedOut).print(any());
    Mockito.doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            printStream.append(invocation.getArguments()[0].toString());
            return null;
        }
    }).when(mockedOut).print(anyString());
    Mockito.doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            printStream.append(invocation.getArguments()[0].toString()).append("\n");
            return null;
        }
    }).when(mockedOut).println(any());
    Mockito.doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            printStream.append(invocation.getArguments()[0].toString()).append("\n");
            return null;
        }
    }).when(mockedOut).println(anyString());
    PrintStream originalOut = System.out;
    System.setOut(mockedOut);
    /* the actual test */
    ArrayList<Integer> listWithOneElement = new ArrayList<Integer>();
    listWithOneElement.add(4);
    OrderedIntList list = new OrderedIntList(listWithOneElement);
    OrderedIntList.printList(list);
    MatcherAssert.assertThat(printStream.toString(), is("[4]\n"));
    /* Teardown - reset System.out */
    System.setOut(originalOut);
}