// Insert a binary data (byte array) into the database
Document document = new Document("blob", "This is a byte array blob".getBytes());
collection.insertOne(document);

// Find and print the inserted byte array as String
for (Document doc : collection.find()) {
    Binary bin = doc.get("blob", org.bson.types.Binary.class);
    System.out.println(new String(bin.getData()));
}