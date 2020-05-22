DBObject query = BasicDBObjectBuilder.start()
    .add("albums",
            new BasicDBObject("$elemMatch",
                    new BasicDBObject("$and", new BasicDBObject[] {
                        new BasicDBObject("albumId", albumDto.getAlbumId()),
                        new BasicDBObject("album",
                            new BasicDBObject("$exists", false))})))
    .get();

Artist result = datastore.createQuery(Artist.class, query).get();