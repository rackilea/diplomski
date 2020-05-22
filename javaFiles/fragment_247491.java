System.setErr(new PrintStream(new OutputStream() {
    public void write(int b) throws IOException {
        //nothing
    }
}));
throw new RuntimeException("test"); //this should not be printed, ever.