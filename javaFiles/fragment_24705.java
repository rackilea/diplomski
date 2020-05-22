Properties params = new Properties();
params.put("user", "postgres");
params.put("passwd", "postgres");
params.put("port", "5432");
params.put("host", "127.0.0.1");
params.put("database", "test");
params.put("dbtype", "postgis");

DataStore dataStore = DataStoreFinder.getDataStore(params);
SimpleFeatureSource source = dataStore.getFeatureSource("tablename");
if (source instanceof SimpleFeatureStore) {
  SimpleFeatureStore store = (SimpleFeatureStore) source;
  store.addFeatures(DataUtilities.collection(features));
} else {
  System.err.println("Unable to write to database");
}