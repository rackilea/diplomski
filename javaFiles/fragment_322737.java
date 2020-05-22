final ProjectionList props = Projections.projectionList();
    props.add(Projections.groupProperty("giftID"));
    props.add(Projections.groupProperty("giftName"));
    props.add(Projections.count("giftID"), "count"); //create an alias for the count
    crit.setProjection(props);

    crit.add(Order.desc("count")); //use the count alias to order by