Problem hashProblem;
String indexName;
Builder builder = new Problem().builder().locationID(condition.getLocationID());
if(condition.getOwner() != null) {
    indexName = sourceLocation ;
    builder.sourceLocation(condition.getSourceLocation())
}
else {
    indexName = currentLocation;
    builder.currentLocation(criteria.getcurrentLocation())
}
hashProblem = builder.build();