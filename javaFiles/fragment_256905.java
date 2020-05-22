public void processEvents(final Map<String, Object> eventData) {
    ExecutorService pool = Executors.newFixedThreadPool(5);
    List<ProcessBundleHolderEntry> entries = new ArrayList<ProcessBundleHolderEntry>();

    Map<String, String> outputs = (Map<String, String>)eventData.get(BConstants.EVENT_HOLDER);
    for (BundleRegistration.BundlesHolderEntry entry : BundleRegistration.getInstance()) {
        ProcessBundleHolderEntry processBundleHolderEntry = new ProcessBundleHolderEntry(entry, outputs);
        entries.add(processBundleHolderEntry);
    }

    try {
        List<Future<Object>> futures = pool.invokeAll(entries, 30, TimeUnit.SECONDS);
        for (int i = 0; i < futures.size(); i++) {
            // This works since the list of future objects are in the
            // same sequential order as the list of entries
            Future<Object> future = futures.get(i);
            ProcessBundleHolderEntry entry = entries.get(i);
            if (!future.isDone()) {
                // log error for this entry
            }
        }
    } catch (InterruptedException e) {
        // handle this exception!
    }
}