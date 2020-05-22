public void run() {
    try {
      consumer.subscribe(topics);
      while (true) {
          ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
        //do something
      }
    } catch (WakeupException e) {
      // do nothing we are shutting down 
    } finally {
      consumer.close();
    }
  }

  public void shutdown() {
    consumer.wakeup();
  }
}