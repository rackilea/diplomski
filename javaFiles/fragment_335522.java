String map = "function() { " +
                 "    var regex1 = new RegExp('autobiography', 'i'); " +
                 "    var regex2 = new RegExp('book', 'i'); " +
                 "    if (regex1.test(this.tweet) ) " +
                 "         emit('Autobiography Tweet', 1); " +
                 "    else if (regex2.test(this.tweet) ) " +
                 "         emit('Book Tweet', 1); " +
                 "    else " +
                 "       emit('Uncategorized Tweet', 1); " +
                 "}";

    String reduce = "function(key, values) { " +
                    "    return Array.sum(values); " +
                    "}";

    MapReduceCommand cmd = new MapReduceCommand(collection, map, reduce,
             null, MapReduceCommand.OutputType.INLINE, null);
    MapReduceOutput out = collection.mapReduce(cmd);

    try {
        for (DBObject o : out.results()) {

            System.out.println(o.toString());

       }
    } catch (Exception e) {
        e.printStackTrace();
    }