public <V> V until(Function<? super T, V> isTrue) {
    long end = clock.laterBy(timeout.in(MILLISECONDS));
    Throwable lastException = null;
    while (true) {
      try {
        V value = isTrue.apply(input);
        if (value != null && Boolean.class.equals(value.getClass())) {
          if (Boolean.TRUE.equals(value)) {
            return value;
          }
        } else if (value != null) {
          return value;
        }
      } catch (Throwable e) {
        lastException = propagateIfNotIngored(e);
      }

      // Check the timeout after evaluating the function to ensure conditions
      // with a zero timeout can succeed.
      if (!clock.isNowBefore(end)) {
        String toAppend = message == null ?
            " waiting for " + isTrue.toString() : ": " + message;

        String timeoutMessage = String.format("Timed out after %d seconds%s",
            timeout.in(SECONDS), toAppend);
        throw timeoutException(timeoutMessage, lastException);
      }

      try {
        sleeper.sleep(interval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new WebDriverException(e);
      }
    }