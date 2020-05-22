public void setTimeoutExceptionThreshold(int timeoutExceptionThreshold) {
        if (timeoutExceptionThreshold <= 0) {
            throw new IllegalArgumentException(
                    "Illegal timeoutExceptionThreshold value "
                            + timeoutExceptionThreshold);
        }
        if (timeoutExceptionThreshold < 100) {
            log.warn("Too small timeoutExceptionThreshold value may cause connections disconnect/reconnect frequently.");
        }
        this.timeoutExceptionThreshold = timeoutExceptionThreshold;
    }