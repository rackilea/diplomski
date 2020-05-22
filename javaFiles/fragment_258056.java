while (!checkValue()) { 
  try {
    Thread.sleep(SLEEP_VALUE);
  } catch (InterruptedException ie) {
    // do something if interrupted...
  }
}