// code with Mockito
@Test
public void testPrint(){
  PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
  PrintStream old = System.out;
  System.setOut(mockedPrintStream);

  obj.print();

  Mockito.verify(mockedPrintStream).println("hello");

  System.setOut(old); // add this line when edit
}