public ObjectId createThing() {
    ObjectId result = new ObjectId();
    BasicDBObject thingToInsert = new BasicDbObject();
    thingToInsert.put('_id', result);
    //set other fields here
    collection.insert(thingToInsert);
    return result;
}