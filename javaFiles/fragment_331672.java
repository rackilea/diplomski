final Logger chatty = Logger.getLogger("somelogger");
final Level oldLevel = chatty.getLevel();
chatty.setLevel(Level.OFF);
try {
  taskThatMakesUnnecessaryLogs();
} finally {
  chatty.setLevel(oldLevel);
}