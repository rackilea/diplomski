UserType coordsType = cluster.getMetadata()
     .getKeyspace("ks")
     .getUserType("coords");
UDTValue coordinates = coordsType.newValue()
    .setDouble("longitude", 2.35)
    .setDouble("latitude", 48.853);
Statement insert = QueryBuilder.insertInto("location_by_name")
    .value("id", id)
    .value("coordinates", coordinates)
    .value("name", name);