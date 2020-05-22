LookupOperation lookupOperation = LookupOperation.newLookup().
                                   from("inventory").
                                   localField("item").
                                   foreignField("sku").
                                   as("inventory_docs");
Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
List<BasicDBObject> results = mongoOperations.aggregate(aggregation, "orders", BasicDBObject.class).getMappedResults();