UnwindOperation unwindAuthorIds = Aggregation.unwind("authorsIds", true);
LookupOperation lookupAuthor = Aggregation.lookup("authors_collection", "authorsIds", "_id", "ref");
UnwindOperation unwindRefs = Aggregation.unwind("ref", true);
GroupOperation groupByAuthor = Aggregation.group("ref.authorName").count().as("count");

Aggregation aggregation = Aggregation.newAggregation(unwindAuthorIds, lookupAuthor, unwindRefs, groupByAuthor);

List<BasicDBObject> results = mongoOperations.aggregate(aggregation, "book_collection", BasicDBObject.class).getMappedResults();