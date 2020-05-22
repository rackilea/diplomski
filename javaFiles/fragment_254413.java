while( !Thread.currentThread().isInterrupted() ) {
  try {
    doRead();
  } catch ( IOException ioe ) {
    // Log exception or whatever
  }
}