final long interval = 20 * 1000;
long lastLogged = System.currentTimeMillis();
while (processing) {
  if (System.currentTimeMillis() - lastLogged > interval) {
    lastLogged = System.currentTimeMillis();
    logToDatabase();
  }
  // do rest of processing
}
// Optionally:
logToDatabase();