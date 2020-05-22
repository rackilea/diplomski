PrintStream original = System.out;
PrintStream redirected = new PrintStream("redirect_test.txt")
try {
    System.out.println("This is the last visible console line");
    System.setOut(redirected);
    System.setErr(redirected);
    System.out.println("This is now redirected!");
    KeyTool.main(keytool_argv);  // "-help" and "-debug" for now
}
catch all the myriad ways things might go wrong { ... }
finally {
    System.setOut(original);
    System.setErr(original);
    System.out.println("Back to normal console output");
}