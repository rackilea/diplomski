protected class NestedProjection implements AggregationExpression {

private List<Field> projectedFields;

public NestedProjection(List<Field> projectedFields) {
  this.projectedFields = projectedFields;

}@Override
public DBObject toDbObject(AggregationOperationContext context) {
  DBObject projectionExpression = new BasicDBObject();
  for(Field f : projectedFields) {
    //this is necessary because if we just put f.getTarget(), spring-mongo will attempt to JSON-escape the string
    DBObject target = (DBObject) com.mongodb.util.JSON.parse(f.getTarget());
      projectionExpression.put(f.getName(), target);


  }
  return projectionExpression;
}