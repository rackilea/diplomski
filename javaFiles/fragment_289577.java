CompletableFuture.runAsync(() -> {
    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
    try {
      email.send();
    } catch (final EmailException e) {
      throw new RuntimeException(e);
    }
  }, Executors.newSingleThreadExecutor());