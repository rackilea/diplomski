// First $group operation
DBObject compoundId = new BasicDBObject( "state", "$state");
compoundId.append("city", "$city")
DBObject groupFields1 = new BasicDBObject( "_id", compoundId );
groupFields1.put("pop", new BasicDBObject( "$sum", "$pop"));
DBObject group1 = new BasicDBObject("$group", groupFields1);

// Second $group operation
DBObject groupFields2 = new BasicDBObject( "_id", "$_id.state");
groupFields2.put("avgCityPop", new BasicDBObject( "$avg", "$pop"));
DBObject group2 = new BasicDBObject("$group", groupFields2);

// Run aggregation
AggregationOutput output = collection.aggregate( group1, group2 );