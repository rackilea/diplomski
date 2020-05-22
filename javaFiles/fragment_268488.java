class HttpSnoopClientHandler ... {
    final BlockingQueue<String> content = new LinkedBlockingQueue<>();
    final StringBuilder contentBuffer = new StringBuilder(...);

    public void channelRead0(...) {
        // On every HttpContent:
        contentBuffer.append(...);

        // On LastHttpContent:
        content.add(contentBuffer.toString());
        contentBuffer.setLength(0);
    }
}