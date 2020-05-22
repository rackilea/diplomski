@Test
public void shouldUpdateAnExistingDocumentWithANewKeyAndValue() {
    // Given
    String docID = "someId";
    collection.save(new BasicDBObject("_id", docID));
    assertThat(collection.find().count(), is(1));

    // When
    String key = "newKeyName";
    String value = "newKeyValue";
    addFieldWithValueToDoc(db.getName(), collection.getName(), docID, key, value);

    // Then
    assertThat(collection.findOne().get(key).toString(), is(value));
}

public void addFieldWithValueToDoc(String DBName, String collName, String docID, String key, String value) {
    BasicDBObject setNewFieldQuery = new BasicDBObject().append("$set", new BasicDBObject().append(key, value));
    mongoClient.getDB(DBName).getCollection(collName).update(new BasicDBObject().append("_id", docID), setNewFieldQuery);
}