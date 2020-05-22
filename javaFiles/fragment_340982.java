@Test(expected = IllegalArgumentException.class)
public void testRunWithLessThanTwoParameters_IllegalArgumentException() 
   throws Exception {

     final String[] args = { "Less Number of parameters" };
     command = spy(new GenerateSummaryReportCommand());      

   try{
     commandLine = new PosixParser().parse(new Options(),Arrays.copyOfRange(args, 0, args.length));
   }catch (Exception e){
     assertEquals(0, command.run(commandLine));      
     verify(command, times(1)).usage();

      throw e;
   }
 }