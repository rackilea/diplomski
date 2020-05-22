public abstract class ClassAbstract extends RichInputFormat<OUT, InputSplit> implements NonParallelInput {

    private final String query;
    private final ClusterBuilder builder;
    private transient Cluster cluster;
    private transient Session session;

    public ClassAbstract(String query, ClusterBuilder builder) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(query), "Query cannot be null or empty");
        Preconditions.checkArgument(builder != null, "Builder cannot be null");
        this.query = query;
        this.builder = builder;
    }

    @Override
    public void configure(Configuration parameters) {
        this.cluster = builder.getCluster();
    }

    @Override
    public BaseStatistics getStatistics(BaseStatistics cachedStatistics) throws IOException {
        return cachedStatistics;
    }

    @Override
    public boolean reachedEnd() throws IOException {
        return resultSet.isExhausted();
    }

    @Override
    public InputSplit[] createInputSplits(int minNumSplits) throws IOException {
        GenericInputSplit[] split = {new GenericInputSplit(0, 1)};
        return split;
    }

    @Override
    public InputSplitAssigner getInputSplitAssigner(InputSplit[] inputSplits) {
        return new DefaultInputSplitAssigner(inputSplits);
    }

    /**
     * Closes all resources used.
     */
    @Override
    public void close() throws IOException {
        try {
            if (session != null) {
                session.close();
            }
        } catch (Exception e) {
            LOG.error("Error while closing session.", e);
        }

        try {
            if (cluster != null) {
                cluster.close();
            }
        } catch (Exception e) {
            LOG.error("Error while closing cluster.", e);
        }
    }

}