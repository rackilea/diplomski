void someMethod(PrintStream ps) {
    ps.print(...);
    ps.format(....);
    // etc
}

someMethod(System.out);                           // Output to console
someMethod(new PrintStream("file.out", "UTF-8")); // Output to a file