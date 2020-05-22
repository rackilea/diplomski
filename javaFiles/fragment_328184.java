Date startdate = new DateTime(2015, 7, 31, 18, 30, 0, DateTimeZone.UTC).toDate();
Date enddate = new DateTime(2015, 8, 1, 18, 30, 0, DateTimeZone.UTC).toDate();

DBObject query = QueryBuilder.start()
        .put("ts").greaterThanEquals(startdate)
        .lessThan(enddate)
        .and("dup").exists(false).get();

DBObject match = new BasicDBObject("$match",query);


DBObject group = new BasicDBObject("$group",
  new BasicDBObject("_id",
    new BasicDBObject(
      "$add", Arrays.asList(
        new BasicDBObject(
          "$subtract", Arrays.asList(
            new BasicDBObject(
             "$subtract", Arrays.asList(
                new BasicDBObject(
                  "$add",Arrays.asList( "$ts", 5.5*1000*60*60 )
                ),
                new Date(0)
              )
            ),
            new BasicDBObject(
              "$mod", Arrays.asList(
                new BasicDBObject(
                 "$subtract", Arrays.asList(
                    new BasicDBObject(
                      "$add",Arrays.asList( "$ts", 5.5*1000*60*60 )
                    ),
                    new Date(0)
                  )
                ),
                1000*60*60*24
              )
            )
          )
        ),
        new Date(0)
      )
    )
  )
  .append("count", new BasicDBObject("$sum",1))
);


AggregationOutput output = collection.aggregate(Arrays.asList(match, group));

for ( DBObject result : output.results() ) {
    System.out.println(result);
}