try {
    final int attempts = 2;
    final long timeout = 2000;
    final String foo = new RetryTemplate<String>(attempts, timeout).execute(() -> {
        // Your retryable logic here!
        return "Lorem ipsum";
    });
} catch (RetryException retryExpectedError) {
    // Your logic if the re-attempts is exceeded.
    // Note: RetryException is a simple inheritance of RuntimeException.
}