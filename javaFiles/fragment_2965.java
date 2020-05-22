private static class ConnectionsSupervisor extends Thread {
    private Set<RequestEntry> streams = new CopyOnWriteArraySet<>();

    public ConnectionsSupervisor() {
        setDaemon(true);
        setName("Connections supervisor");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(CONNECTIONS_SUPERVISOR_WAIT_MS);
            } catch (InterruptedException ignored) {
            }
            long time = timestamp();
            streams.stream().filter(entry -> time > entry.timeoutBorder).forEach(entry -> {
                HttpUriRequest request = entry.request;
                System.err.format("HttpUriRequest killed after timeout (%d sec.) exceeded: %s%n",
                        FULL_CONNECTION_TIMEOUT_S,
                        request);
                request.abort();
            });
        }
    }

    public void addRequest(HttpUriRequest request) {
        streams.add(new RequestEntry(timestamp() + FULL_CONNECTION_TIMEOUT_S, request));
    }

    public void removeRequest(HttpUriRequest request) {
        streams.removeIf(entry -> entry.request == request);
    }

    private static class RequestEntry {
        private long timeoutBorder;
        private HttpUriRequest request;

        public RequestEntry(long timeoutBorder, HttpUriRequest request) {
            this.timeoutBorder = timeoutBorder;
            this.request = request;
        }
    }
}


public static long timestamp() {
    return Instant.now().getEpochSecond();
}