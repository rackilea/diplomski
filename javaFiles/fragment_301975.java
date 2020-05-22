DBObject taxigroup = new BasicDBObject("$group",
                               new BasicDBObject("_id", 
                                   new BasicDBObject("station","$TaxiStation")
                                   .append("Licence","$TaxiLicense"))
                               .append("count", new BasicDBObject("$sum",1)));
AggregationOutput aggout = taxistationOfCollection.aggregate(
                                                      Arrays.asList(taxigroup));