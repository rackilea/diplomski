String[] elements = deletedRow.split(",");
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

for (String element : elements) {
    Key key = KeyFactory.createKey("Row", element);
    datastore.delete(key);
}