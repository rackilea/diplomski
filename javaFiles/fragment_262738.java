MongoClient client = new MongoClient();
    GridFS gridFS = new GridFS(client.getDB("test");
    GridFSInputFile in = gridFS.createFile(<insert bytes here>);
    in.put("meta", 5);  // insert extra metadata here
    in.save();
    GridFSDBFile out = gridFS.findOne( new BasicDBObject( "_id" , in.getId() ) );
    System.out.println(out.get("meta"));  // this will print 5