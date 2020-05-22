Executor ex = new DefaultExecutor();
ex.setStreamHandler(new PumpStreamHandler(new LogOutputStream() {
    @Override
    protected void processLine(String line, int level) {
        // Call PircBot's sendMessage() passing line
    }
}));
int exitValue = ex.execute("command to execute locally");