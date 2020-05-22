public
  void emitNoAppenderWarning(Category cat) {
    // No appenders in hierarchy, warn user only once.
    if(!this.emittedNoAppenderWarning) {
      LogLog.warn("No appenders could be found for logger (" +
           cat.getName() + ").");
      LogLog.warn("Please initialize the log4j system properly.");
      LogLog.warn("See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.");
      this.emittedNoAppenderWarning = true;
    }
  }