private SecurityManager previousManager=null;


@Before
protected void replaceManager() throws Throwable {
    previousManager = System.getSecurityManager();
    System.setSecurityManager(NON_EXITABLE_MANAGER);
}

@After
protected void restoreManager() {
    System.setSecurityManager(previousManager);
}

 @Test
public void testCallToExit() throws IOException{

     try{
       //something that calls System.exit
        fail("should call exit");
     }catch(TriedToExitException e){
         //make sure we get correct exit code
         assertEquals(-1, e.getExitCode());

     }
}