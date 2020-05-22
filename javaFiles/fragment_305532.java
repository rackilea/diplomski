HiveContext sqlContext = new HiveContext(sc);

    List<Event> list = new ArrayList<>();
    list.add(new Event(1, "event1", Timestamp.valueOf("2017-01-01 00:00:00"), Timestamp.valueOf("2017-01-03 00:00:00")));
    list.add(new Event(2, "event2", Timestamp.valueOf("2017-01-02 00:00:00"), Timestamp.valueOf("2017-01-03 00:00:00")));

    List<Event> list2 = new ArrayList<>();
    list2.add(new Event(1, "event11", Timestamp.valueOf("2017-01-02 00:00:00"), Timestamp.valueOf("2017-01-10 00:00:00")));
    list2.add(new Event(2, "event22", Timestamp.valueOf("2017-01-01 00:00:00"), Timestamp.valueOf("2017-01-15 00:00:00")));

    DataFrame df1 = getDF(sc, sqlContext, list);
    DataFrame df2 = getDF(sc, sqlContext, list2);

    df1.join(df2,df1.col("startTime").gt(df2.col("startTime"))).show();