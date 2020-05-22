List<Document> aggregationList = new ArrayList()<>;
aggregationList.add(match(eq(BELONGS_TO_OWNER_DSID, dsId)));
aggregationList.add(match(eq(IS_DELETED, false)));
if (valueOfMonth != 0) {
    List<Bson> filters = new ArrayList<Bson>();
    filters.add(gt(TECHNOLOGY_VERSION_EOL_KEY, LocalDate.now()));
    filters.add(lt(TECHNOLOGY_VERSION_EOL_KEY, getFutureDate(valueOfMonth)));
    aggregationList.add(match(and(filters)));
}

aggregationList.add(project(Projections.include(TECHNOLOGY, APPLICATION)));
// add other stages...

AggregateIterable<Document> result = coll.aggregate(aggregationList, Document.class);