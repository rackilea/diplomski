//set err out to print to file
PrintStream ps = new PrintStream("err.log");
System.setErr(ps);

//cause exception for testing it
String s = null;
s.length();