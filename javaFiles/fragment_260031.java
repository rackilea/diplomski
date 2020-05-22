List<BsonField> fieldAccumulators = new ArrayList<>();
if (error1)
    fieldAccumulators.add(Accumulators.sum("error1","$stream.error1"));
if (error2)
    fieldAccumulators.add(Accumulators.sum("error2","$stream.error2"));
if (error3)
   fieldAccumulators.add(Accumulators.sum("error3","$stream.error3"));
collection.aggregate(Arrays.asList(Aggregates.group("$stream.name", fieldAccumulators)));