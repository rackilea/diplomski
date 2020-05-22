{
    Thread thread = new Thread(() -> readEvents(url, streamingMode));
}

static void readEvents(String serviceUrl, boolean streamingMode) {
    // ...
}