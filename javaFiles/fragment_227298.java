synchronized (lock) {
    for (Object cancellableResource : cancellableResources) {
        if (cancellableResource instanceof HttpURLConnection) {
            ((HttpURLConnection) cancellableResource).disconnect();
            success = true;
        }
    }
}