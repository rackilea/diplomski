@Test
public boolean testPrintAdequateOption() {   
     // overwrite stdout to allow for capturing print statement
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     PrintStream ps = new PrintStream(baos);
     PrintStream sout = System.out;
     System.setOut(ps);

     // call method with specific input
     String text = ...
     double[] sol = ...
     Formatter formatter = ...
     printAdequateOption(text, sol, formatter);

     System.out.flush();
     System.setOut(sout);

     assertThat(baos.toString(), is("expected output));
  }