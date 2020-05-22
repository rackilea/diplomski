CustomGenericOperation customGenericOperation = 
    new CustomGenericOperation(new BasicDBObject("$sample", new BasicDBObject("size", 1)));    
...

public class CustomGenericOperation implements AggregationOperation {
    private DBObject dbObject;
    public CustomGenericOperation(DBObject dbObject){
        this.dbObject = dbObject;

    }
    @Override
    public DBObject toDBObject(final AggregationOperationContext context) {
        return dbObject;
    }
}