public List<MyClass> findThings(Collection<ObjectId> ids) {
    Criteria criteria = where(ID).in(ids);
    Aggregation matchAndProject = newAggregation(
            match(criteria),
            project("field1", "field2")
                    .and(ConditionalOperators.when("testedField")
                        .then(true)
                        .otherwise(false))
                    .as("myBoolVal"));
    return mongoTemplate.aggregate(matchAndProject, "my_collection", MyClass.class).getMappedResults();
}