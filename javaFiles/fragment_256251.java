String map = "function() {\n" +
            "                   var array = [5, 5, 10];\n" +
            "                   for (var idx = 0; idx < array.length; idx++) {\n" +
            "                       var key = 'testValue';\n" +
            "                       var value = array[idx];\n" +
            "                       emit(key, value);\n" +
            "                   }\n" +
            "             };";

String reduce = "function(key, values) {return Array.sum(values);};";

// MAP REDUCE
collection.mapReduce(map, reduce).action(MapReduceAction.REPLACE).collectionName("index").first();