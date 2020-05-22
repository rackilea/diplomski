PrintStream standard = System.out;
PrintStream out = new PrintStream(fistr);
System.setOut(out);
/*
 some other stuff
*/
System.setOut(standard);