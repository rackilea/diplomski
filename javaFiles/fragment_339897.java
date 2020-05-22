getExecutor().submit(() -> {
    processBatch(batch, metacard -> {
        try {
            backupMetacard(metacard);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    });
});