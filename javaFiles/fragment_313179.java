public class CustomSampleOperation implements AggregationOperation {
    private int size;
    public CustomSampleOperation(int size){
        this.size = size;   
    }

    @Override
    public DBObject toDBObject(final AggregationOperationContext context){
        return new BasicDBObject("$sample", new BasicDBObject("size", size));
    }
}