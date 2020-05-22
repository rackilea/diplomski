Completable single = server.rxClose();

    // Subscribe to bind the server
    single.
      subscribe(
        () -> {
          // Server is closed
        },
        failure -> {
          // Server closed but encoutered issue
        }
      );