Criteria toolQuery = Criteria.where("madeInCountry").in("germany");
 MatchOperation toolMatchOperation = new MatchOperation(toolQuery);
 LookupOperation lookupOperation = LookupOperation.newLookup().
                from("cars").
                localField("usedIn.carId").
                foreignField("_id").
                as("usedIn.car");
 Criteria carQuery = Criteria.where("usedIn.car.madeInCountry").is("germany");
 MatchOperation carMatchOperation = new MatchOperation(carQuery);

 TypedAggregation<ToolDocument> aggregation = Aggregation.newAggregation(ToolDocument.class, toolMatchOperation, Aggregation.unwind("usedIn"), lookupOperation, Aggregation.unwind("usedIn.car"), carMatchOperation,
                Aggregation.group("id").push("usedIn").as("usedIn"));
 List<ToolDocument> results = mongoTemplate.aggregate(aggregation, ToolDocument.class).getMappedResults();