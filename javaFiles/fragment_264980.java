String runTests() {
    PrintStream sysOut = System.out;
    PrintStream sysErr = System.err;
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    try {
        System.setOut(out);
        System.setErr(out);
        TextListener listener = new TextListener(out);
        JUnitCore junit = new JUnitCore();
        junit.addListener(listener);

        junit.run(MyClassIT.class,
                  AnotherClassIT.class,
                  ...etc...);

    } finally {
        System.setOut(sysOut);
        System.setErr(sysErr);
        out.close();
    }

    return stream.toString();
}