private void testSpreadsheet(){
  File dtf = new File( dtPath );
  InputStream is;
  try {
    is = new FileInputStream( dtf );
    SpreadsheetCompiler ssComp = new SpreadsheetCompiler();
    String s = ssComp.compile( is, InputType.XLS );
    System.out.println( "=== Begin generated DRL ===" );
    System.out.println( s );
    System.out.println( "=== End generated DRL ===" );
  } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
}