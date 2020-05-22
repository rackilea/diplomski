IndexQuery iq = new BinValueQuery(BinIndex.named("field1"),
        "bucketName", "car");
Function mapFunction = new JSSourceFunction(
        "function(v) {" +
            "var range = v.values[0].metadata.index.field2;" +
            "if (range <= 4 && range >= 2) {" +
                "return [v.values[0]];" +
            "}" +
            "return [];" +
        "}");
Function reduceFunction = new JSSourceFunction(
        "function(v) {" +
            "return [v.sort(function(a, b) {" +
                                 "return a.metadata.index.field2 - b.metadata.index.field2;" +
                            "}" +
                     ")];" +
         "}");
MapReduceResult result = RiakUtils.getClient().mapReduce(iq)
                            .addMapPhase(mapFunction)
                            .addReducePhase(reduceFunction)
                            .execute();

// Print the results
System.out.println(result.getResultRaw());