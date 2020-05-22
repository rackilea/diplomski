String logConfig = ".level=" + java.util.logging.Level.INFO + '\n';
logConfig += "handlers=java.util.logging.ConsoleHandler\n";
// ensure ConsoleHandler does not filter
logConfig += "java.util.logging.ConsoleHandler" + ".level=" + java.util.logging.Level.FINEST + '\n';

//set your custom levels
logConfig += "org.apache.cxf" + ".level=" + java.util.logging.Level.WARNING + "\n";

try {
  java.util.logging.LogManager.getLogManager().readConfiguration(new java.io.ByteArrayInputStream(logConfig.getBytes("UTF-8")));
  // no need to close ByteArrayInputStream -- it is a no-op
}
catch (IOException ioe) {
  System.err.println("cannot fully configure logging");
  ioe.printStackTrace();
}