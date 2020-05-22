// Construct our _id to group on
DBObject fields = new BasicDBObject( "requestId", "$requestId" );
fields.put( "telNum", "$telNum" );

// Contruct group element
DBObject groupFields = new BasicDBObject( "_id", fields );
groupFields.put( "count", new BasicDBObject( "$sum", 1 ) );
DBObject group = new BasicDBObject( "$group", groupFields );



// Run aggregation
AggregationOutput output = collection.aggregate( group );