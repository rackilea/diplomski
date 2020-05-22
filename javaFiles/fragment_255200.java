public static void close(@Nullable Process process) throws IOException {
  if (process == null) {
    return;
  }

  Throwable t = null;

  try {
    flushQuietly(process.getOutputStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    close(process.getOutputStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    skipAllQuietly(null, TIMEOUT, process.getInputStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    close(process.getInputStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    skipAllQuietly(null, TIMEOUT, process.getErrorStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    close(process.getErrorStream());
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  try {
    try {
      Thread monitor = ThreadMonitor.start(TIMEOUT);
      process.waitFor();
      ThreadMonitor.stop(monitor);
    }
    catch (InterruptedException e) {
      t = mostImportantThrowable(t, e);
      process.destroy();
    }
  }
  catch (Throwable e) {
    t = mostImportantThrowable(t, e);
  }

  if (t != null) {
    if (t instanceof Error) {
      throw (Error) t;
    }

    if (t instanceof RuntimeException) {
      throw (RuntimeException) t;
    }

    throw t instanceof IOException ? (IOException) t : new IOException(t);
  }
}