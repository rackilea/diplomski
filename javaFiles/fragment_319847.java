// Load log4j config file...
String path = "/path/to/log4j.xml");
DOMConfigurator.configureAndWatch(path, 30000); // 30sec poll

// Start Logging
LOG = Logger.getLogger(Program.class);