// Load log4j config file...
String path = "/path/to/log4j.xml");
DOMConfigurator.configure(path);

// Start Logging
LOG = Logger.getLogger(Program.class);