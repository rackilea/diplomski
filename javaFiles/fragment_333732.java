// Test read as MyObject
String keyToRead3 = key1;
MyObject doc3 = arangoDB.db(dbName).collection(collName).getDocument(keyToRead3, MyObject.class);
if (doc3 != null)
   System.out.println("Open document " + keyToRead3 + " as MyObject: " + doc3.getName() + " " + doc3.getAge());
else
   System.err.println("Could not open the document " + keyToRead3 + " as MyObject");