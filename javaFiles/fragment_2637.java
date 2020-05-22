Query<Event> q = ads.getQueryFactory().createQuery(ads);
Criteria[] arrayA = {
    q.criteria("info.name").equal("messageType"), 
    q.criteria("info.value").equal("Push"),
    q.field("timestamp").greaterThan(start);
    q.field("timestamp").lessThan(end);
};

Criteria[] arrayB = {
    q.criteria("info.name").equal("messageType"), 
    q.criteria("info.value").equal("Push")  
};

q.and(
    q.criteria("identifier").in(ids),
    q.or(arrayA)
);

Query<Event> query = ads.getQueryFactory().createQuery(ads);
query.or(arrayB);

AggregationPipeline pipeline = ads.createAggregation(Event.class)
                                  .match(q)
                                  .unwind("info")
                                  .match(query);
Iterator<Event> iterator =  pipeline.aggregate(Event.class);