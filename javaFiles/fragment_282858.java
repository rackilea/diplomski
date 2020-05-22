while (!shutdown && !Thread.currentThread().isInterrupgted()) {
    String text = textQueue.poll(1, TimeUnit.SECONDS);
    if (text != null) {
        // write the text
    }
}