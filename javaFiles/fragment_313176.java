public class CustomAggregationOperation implements AggregationOperation {
    private DBObject operation;
    public CustomAggregationOperation (DBObject operation) {
        this.operation = operation;
    }
    @Override
    public DBObject toDBObject(final AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}