public static void hello(){
    System.out.println("Hello");
}


@Test void Test(){
  System.setOut(new PrintStream(outContent));
  System.setErr(new PrintStream(errContent));

  hello();

  // Changed the line below  
  assertEquals("Hello" + System.lineSeparator(), outContent.toString());

  System.setIn(System.in);
  System.setOut(originalOut);
  System.setErr(originalErr);
}