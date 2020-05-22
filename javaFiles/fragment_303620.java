import org.bson.types.ObjectId;

public DBObject findDocumentById(String id) {
    BasicDBObject query = new BasicDBObject();
    query.put("_id", new ObjectId(id));
    DBObject dbObj = collection.findOne(query);
    return dbObj;
 }