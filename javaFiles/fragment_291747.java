Observable.create(subscriber -> {
        // code that may throw exceptions
    }).map(item -> { 
        // code that will not throw any exceptions
    }).retryWhen(...)
      ...