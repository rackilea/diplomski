Marker fatal = MarkerFactory.getMarker("FATAL");
// Usage example
final Logger logger = LoggerFactory.getLogger(FatalLogger.class);
logger.log(fatal, "this is a fatal message");

// Log sample : 
20150514T115144,279  FATAL [main] FatalLogger - this is a fatal message