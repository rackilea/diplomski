private volatile boolean isListening = false;
    ...

    public void startListening() {
    try {
      queueConnection.start();
      isListening = true;
    } catch (JMSException e) {
      throw new RunTimeException("Failed to start listening to queue", e);
    }
  }

  public void stopListening() {
    try {
      queueConnection.stop();
      isListening = false;
    } catch (JMSException e) {
      throw new RunTimeException("Failed to stop listening to queue", e);
    }
  }

  public void close() {
    if (queueConnection != null) {
      try {
        queueConnection.close();
        isListening = false;
      } catch (JMSException e) {
        throw new RunTimeException("Failed to stop listening to queue", e);
      }
    }
  }

  public boolean isRunning() {
      return isListening;
  }