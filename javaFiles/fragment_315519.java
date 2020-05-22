File inFile = new File("/home/ian/Data/states/states.geojson");
Map<String, Object> params = new HashMap<>();
params.put(GeoJSONDataStoreFactory.URLP.key, URLs.fileToUrl(inFile));
DataStore newDataStore = DataStoreFinder.getDataStore(params);
String pt = "POINT (-107 42)";

FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
SimpleFeatureSource featureSource = newDataStore.getFeatureSource(newDataStore.getTypeNames()[0]);
Filter f = ff.contains(ff.property(featureSource.getSchema().getGeometryDescriptor().getLocalName()),
    ff.literal(pt));
SimpleFeatureCollection collection = featureSource.getFeatures(f);
if (collection.size() > 0) {
  try (SimpleFeatureIterator itr = collection.features()) {
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}