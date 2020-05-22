collection.updateOne(
    new BasicDBObject("product_id", pid),
    new BasicDBObject("$set",
        new BasicDBObject("cls", justClsValue)
    )
);