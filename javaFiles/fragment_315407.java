private static class State {
    private final List<ProcessMetadata> processMetadata;
    private final List<ProcMetadata> procMetadata;
    private final List<String> topicMetadata;

    public State(final List<ProcessMetadata> processMetadata, 
        final List<ProcMetadata> procMetadata, final List<String> topicMetadata) {
        this.processMetadata = new ArrayList<>(processMetadata);
        this.procMetadata = new ArrayList<>(procMetadata);
        this.topicMetadata = new ArrayList<>(topicMetadata);
    }
    // Getters
}