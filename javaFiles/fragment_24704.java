// loop through features adding new attribute
List<SimpleFeature> features = new ArrayList<>();
try (SimpleFeatureIterator itr = ds.getFeatureSource().getFeatures().features()) {
  while (itr.hasNext()) {
    SimpleFeature f = itr.next();
    SimpleFeature f2 = DataUtilities.reType(nSchema, f);
    f2.setAttribute("shapeID", "newAttrValue");
    //System.out.println(f2);
    features.add(f2);
  }
}