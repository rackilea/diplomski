protected synchronized void checkTransfers() {
    if (isPaused())
        return;
    while (transferQueue.peek() != null && (transferQueue.peek().priority == PRIORITY_URGENT ||
            (transferSemaphore.availablePermits() > maxConcurrentTransfers)))
    {
        CommunicationTask ct = transferQueue.poll();
        if (ct != null)
        {
            if (ct instanceof DownloadTask)
                currentlyDownloading.add((DownloadTask)ct);
            ct.execute();
        }
    }
}