if (Thread.interrupted()) {
    // Not really necessary, but could help if the library does check it itself in some other place:
    Thread.currentThread().interrupt();
    // Wrapping the checked InterruptedException because the signature doesn't declare it:
    throw new RuntimeException(new InterruptedException());
}