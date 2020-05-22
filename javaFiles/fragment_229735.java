MapReduceCommand wktgtcmd = new MapReduceCommand(tgtCollection, 
                                                 wk_map_function, 
                                                 tgt_reduce_function, 
                                                 null,
                                                 MapReduceCommand.OutputType.INLINE, 
                                                 null);
 MapReduceOutput out = tgtCollection.mapReduce(cmd);


 DB db = mongo.getDB("database");
 DBCollection results = db.getCollection("collection");
 for (DBObject o : out.results()) {
    results.insert(o);
 }