job.waitUntilFinished();
    if (job.getErrors() > 0) {
      Log4jBufferAppender appender = CentralLogStore.getAppender();
      appender.removeGeneralMessages();
      String logText = appender.getBuffer(job.getLogChannelId(), false).toString();
      CentralLogStore.discardLines(job.getLogChannelId(), false);
      throw new RuntimeException(logText);
    }