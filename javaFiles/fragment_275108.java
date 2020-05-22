PrintStream stdout = System.out;
System.setOut(new PrintStream(logFile));

// ...

System.setOut(stdout);                   // reset to standard output