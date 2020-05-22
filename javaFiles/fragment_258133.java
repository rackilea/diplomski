if (reply == null && this.errorOnTimeout) {
    if (object instanceof Message) {
        error = new MessageTimeoutException((Message<?>) object, "No reply received within timeout");
    }
    else {
        error = new MessageTimeoutException("No reply received within timeout");
    }
}