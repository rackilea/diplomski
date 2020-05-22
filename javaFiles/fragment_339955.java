DataStore dataStore = DataStoreFinder.getDataStore(params);
if (dataStore == null) {
  System.out.println("Failed to connect to PostGIS");
  System.exit(1);
}
String tableName = nSchema.getTypeName();
boolean exists = false;
String[] names = dataStore.getTypeNames();
for (String name : names) {
  if (name.equalsIgnoreCase(tableName)) {
    exists = true;
    break;
  }
}
if (!exists) {
  dataStore.createSchema(nSchema);
}
SimpleFeatureSource source = dataStore.getFeatureSource(tableName);
if (source instanceof SimpleFeatureStore) {
  SimpleFeatureStore store = (SimpleFeatureStore) source;
  store.addFeatures(DataUtilities.collection(features));
} else {
  System.err.println("Unable to connect to database");
}