public class LimitOperation implements AggregationOperation {
    private final long maxElements;
    public LimitOperation(long maxElements) {
        this.maxElements = maxElements;
    }

    public DBObject toDBObject(AggregationOperationContext context) {    
        return new BasicDBObject("$limit", maxElements);
    }
}