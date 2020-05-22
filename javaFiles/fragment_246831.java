private InputStream getStream() {

 String dataParsingCommand = "java";

PipedOutputStream output = new PipedOutputStream();
PumpStreamHandler psh = new PumpStreamHandler(output);

CommandLine cl = CommandLine.parse(command);
cl.addArgument("-jar");
cl.addArgument(dataParserPath);

DefaultExecutor exec = new DefaultExecutor();
DataInputStream is = null;
try {
    is = new DataInputStream(new PipedInputStream(output));
    exec.setStreamHandler(psh);
    exec.execute(dataParserCommandLine);
} catch (ExecuteException ex) {
} catch (IOException ex) {
}

return is;
}