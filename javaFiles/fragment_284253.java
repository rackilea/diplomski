// Creating an ArrayList to store all the different fruits
ArrayList<BasicDBObject> newField = new ArrayList<BasicDBObject>();
for (...) {
    String value = "";
    String type = "";
    BasicDBObject newItem = new BasicDBObject("value", value).append("type", type);
    newField.add(newItem);
}

// Removing duplicates from ArrayList
Set<BasicDBObject> setItems = new LinkedHashSet<BasicDBObject>(newField);
newField.clear();
newField.addAll(setItems);

// Adding ArrayList of fruits into database
BasicDBObject update = new BasicDBObject();
update.put("$set", new BasicDBObject("FRUITS", newField));
WriteResult result = coll.update({"_id":"1"}, update, true, false);