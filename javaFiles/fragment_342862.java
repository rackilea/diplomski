List<Bson> arrayFilters = new ArrayList<>();
arrayFilters.add(new Document("elem.apn", "abcdef"));
FindOneAndUpdateOptions updateOptions = 
    new FindOneAndUpdateOptions().arrayFilters(arrayFilters);   

Bson pushUpdate = push("session.ps.$[elem].d", "gua");
Bson setUpdate = set("session.ps.$[elem].apn", "newValue");
Bson update = combine(pushUpdate, setUpdate);

String idStr = "5e37dc262f5ff4dfc935eb6b";
Bson queryFilter = eq("_id", new ObjectId(idStr));

Document result = coll.findOneAndUpdate(queryFilter, update, updateOptions);