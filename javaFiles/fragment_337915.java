try {
    FileOutputStream fos = new FileOutputStream(f);
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try {
            fos.flush();
        }
        catch (Throwable t) {
            // Ignore
        }
    }, "Shutdown hook Thread flushing " + f));
    //we will want to print in standard "System.out" and in "file"
    TeeOutputStream myOut=new TeeOutputStream(System.out, fos);
    PrintStream ps = new PrintStream(myOut, true); //true - auto-flush after println
    System.setOut(ps);
} catch (Exception e) {
    e.printStackTrace();
}