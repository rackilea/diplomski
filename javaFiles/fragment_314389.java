public class GroupAggregationOperation implements AggregationOperation {
    private DBObject operation;

    public GroupAggregationOperation (DBObject operation) {
        this.operation = operation;
    }

    @Override
    public DBObject toDBObject(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}