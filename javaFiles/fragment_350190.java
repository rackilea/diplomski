@Test(expected = ExitException.class)
public void verifyHelpOptionsRun() throws Exception{
    String[] args = new String[]{};

    // mock record first
    when(cli.parse(args)).thenReturn(null); 

    // execute the method to test
    runner.run(args);        

    // do some checks (if required)
    verify(cli, times(1)).parse(args);
    verify(cli, times(1)).help();
}