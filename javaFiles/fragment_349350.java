BasicDBList points = new BasicDBList();
    points.add(bbox.getNe());
    points.add(bbox.getSe());
    points.add(bbox.getSw());
    points.add(bbox.getNw());
    points.add(bbox.getNe());
    BasicDBList parentList = new BasicDBList();
    parentList.add(points);

    Set<Object> data = new CopyOnWriteArraySet<Object>();

    DBObject query = new BasicDBObject("geometry",
            new BasicDBObject("$geoWithin",
                    new BasicDBObject("$geometry", new BasicDBObject("type","Polygon")
                            .append("coordinates", parentList))));
    System.err.println(query);