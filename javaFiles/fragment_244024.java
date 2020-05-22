if (logger.isWarnEnabled()) {
   StringWriter sw = new StringWriter();
   PrintWriter pw = new PrintWriter(sw);
   e.printStackTrace(pw);
   String expanded = sw.toString(); // stack trace as a string
   logger.warn("Failed to load User {} - Reason : {}", userId, expanded);
}