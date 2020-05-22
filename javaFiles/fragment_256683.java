public void methodB() {
 // do something with the file
 File file = new File("/example.txt");
 try {
   methodA(file);
  }
  catch (CustomUserInputException ex) {
    showErrorToAnUser();
    stopStandardProgramExecution();
  }
}