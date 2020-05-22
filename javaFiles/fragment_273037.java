public class CustomGroupOperation implements AggregationOperation {
    private DBObject operation;

    public CustomGroupOperation (DBObject operation) {
        this.operation = operation;
    }

    @Override
    public DBObject toDBObject(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}