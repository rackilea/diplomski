final TarGZipUnArchiver ua = new TarGZipUnArchiver();
// Logging - as @Akom noted, logging is mandatory in newer versions, so you can use a code like this to configure it:
ConsoleLoggerManager manager = new ConsoleLoggerManager();
manager.initialize();
ua.enableLogging(manager.getLoggerForComponent("bla"));
// -- end of logging part
ua.setSourceFile(sourceFile);
destDir.mkdirs();
ua.setDestDirectory(destDir);
ua.extract();