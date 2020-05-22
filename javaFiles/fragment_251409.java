@Test
public void serializePoinInCriteriaNearSphere() throws Exception {

... as above ...

    Point p = new Point(-73, 40);
    Circle circle = new Circle(p, new Distance(150.0, Metrics.KILOMETERS));

    TypedAggregation<EventWithLocation> agg = newAggregation(EventWithLocation.class, //
            match(where("eventTime").gte(1).and("location").withinSphere(circle)) //
            , sort(Direction.DESC, "eventTime") //
            , group("vanId").first(Aggregation.ROOT).as("first") //
    );

... as above
}