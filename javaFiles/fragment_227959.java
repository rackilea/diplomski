// This code is almost taken from the SimpleRemoteLogHandler.java because
  // it is a final class and we cannot extend it.
  logger.addHandler(new RemoteLogHandlerBase() {

    private AsyncCallback<String> callback = new AsyncCallback<String>() {
      public void onFailure(Throwable caught) {
        wireLogger.log(Level.SEVERE, "Remote logging failed: ", caught);
      }
      public void onSuccess(String result) {
        if (result != null) {
          wireLogger.severe("Remote logging failed: " + result);
        } else {
          wireLogger.finest("Remote logging message acknowledged");
        }
      }
    };

    private RemoteLoggingServiceAsync service = (RemoteLoggingServiceAsync) GWT.create(RemoteLoggingService.class);

    @Override
    public void publish(LogRecord record) {
      if (record.getLevel() == Level.SEVERE) {
        if (isLoggable(record)) {
          service.logOnServer(record, callback);
        }
      }
    }

  });