public class ProcessBundleHolderEntry implements Callable {
    private BundleRegistration.BundlesHolderEntry entry;
    private Map<String, String> outputs;

    public ProcessBundleHolderEntry(BundleRegistration.BundlesHolderEntry entry, Map<String, String> outputs) {
        this.entry = entry;
        this.outputs = outputs;
    }

    public Object call() throws Exception {
        final Map<String, String> response = entry.getPlugin().process(outputs);
        // write to the database.
        System.out.println(response);
        return response;
    }
}