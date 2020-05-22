@Test
public void serializePoinInCriteriaNearSphere() throws Exception {

    mongoTemplate.dropCollection(EventWithLocation.class);
    mongoTemplate.insert(new EventWithLocation(3, new Point(-73.99408, 40.75057), "42"));

    mongoTemplate.indexOps(EventWithLocation.class).ensureIndex(new GeospatialIndex("location"));

    Point p = new Point(-73, 40);
    NearQuery geoNear = NearQuery.near(p, Metrics.KILOMETERS).maxDistance(150.0);

    TypedAggregation<EventWithLocation> agg = newAggregation(EventWithLocation.class, //
            geoNear(geoNear, "distance") //
            , match(where("eventTime").gte(1)) //
            , sort(Direction.DESC, "eventTime") //
            , group("vanId").first(Aggregation.ROOT).as("first") //
    );

    AggregationResults<DBObject> results = mongoTemplate.aggregate(agg, DBObject.class);
    List<DBObject> list = results.getMappedResults();

    DBObject firstResult = list.get(0);
    assertThat(firstResult.get("_id"), is(equalTo((Object)"42")));
}