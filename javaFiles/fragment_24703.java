FileDataStore ds = FileDataStoreFinder.getDataStore(new File("/home/ian/Data/states/states.shp"));
SimpleFeatureType schema = ds.getSchema();
// create new schema
SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
builder.setName(schema.getName());
builder.setSuperType((SimpleFeatureType) schema.getSuper());
builder.addAll(schema.getAttributeDescriptors());
// add new attribute(s)
builder.add("shapeID", String.class);
// build new schema
SimpleFeatureType nSchema = builder.buildFeatureType();