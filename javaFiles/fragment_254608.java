// Construct a match on things with a count of more than 1
DBObject greaterThan = new BasicDBObject( "$gt", 1 );
DBObject matchFields = new BasicDBObject( "count", greaterTen );
DBObject match = new BasicDBObject( "$match", matchFields );

// Count the documents that match
DBObject newGroupFields = new BasicDBObject( "_id", null );
newGroupFields.put( "count", new BasicDBOject( "$sum", 1 ) );
DBObject group2 = new BasicDBObject( "$group", newGroupFields );

// Run aggregation
AggregationOutput output = collection.aggregate( group, match, group2 );