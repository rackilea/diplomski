@Test
public void foo() {

    mongoTemplate.dropCollection(RssSearchResponse.class);

    RssSearch rs = new RssSearch();
    rs.id  = "123";
    rs.rssSearchResponse = new RssSearchResponse(
            new Journey[] {new Journey("A", 1),new Journey("B", 0),new Journey("C", 0),new Journey("D", 1)}
    );

    mongoTemplate.insert(rs);

    Aggregation agg = newAggregation(RssSearch.class, //
          match(where("_id").is(rs.id)) //
        , project("rssSearchResponse.journeys") //
        , unwind("journeys") //
        , match(where("journeys.stops").is(0)) //
    );

    AggregationResults<DBObject> result = mongoTemplate.aggregate(agg, RssSearch.class, DBObject.class);
    System.out.println(result);

}

static class RssSearch{
    String id;
    RssSearchResponse rssSearchResponse;
}

static class RssSearchResponse{
    Journey[] journeys;

    public RssSearchResponse(Journey[] journeys) {
        this.journeys = journeys;
    }
}

static class Journey{
    String name;
    int stops;

    public Journey(String name, int stops) {
        this.name = name;
        this.stops = stops;
    }
}