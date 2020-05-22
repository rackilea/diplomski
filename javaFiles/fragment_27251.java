public boolean writeFeatures(
        FeatureCollection<SimpleFeatureType, SimpleFeature> features) {

    if (shpDataStore == null) {
        throw new IllegalStateException(
                "Datastore can not be null when writing");
    }
    SimpleFeatureType schema = features.getSchema();
    GeometryDescriptor geom = schema
            .getGeometryDescriptor();

    try {

        /*
         * Write the features to the shapefile
         */
        Transaction transaction = new DefaultTransaction(
                "create");

        String typeName = shpDataStore.getTypeNames()[0];
        SimpleFeatureSource featureSource = shpDataStore
                .getFeatureSource(typeName);

        /*
         * The Shapefile format has a couple limitations: - "the_geom" is always
         * first, and used for the geometry attribute name - "the_geom" must be of
         * type Point, MultiPoint, MuiltiLineString, MultiPolygon - Attribute
         * names are limited in length - Not all data types are supported (example
         * Timestamp represented as Date)
         *
         * Because of this we have to rename the geometry element and then rebuild
         * the features to make sure that it is the first attribute.
         */

        List<AttributeDescriptor> attributes = schema
                .getAttributeDescriptors();
        GeometryType geomType = null;
        List<AttributeDescriptor> attribs = new ArrayList<AttributeDescriptor>();
        for (AttributeDescriptor attrib : attributes) {
            AttributeType type = attrib.getType();
            if (type instanceof GeometryType) {
                geomType = (GeometryType) type;

            } else {
                attribs.add(attrib);
            }
        }

        GeometryTypeImpl gt = new GeometryTypeImpl(
                new NameImpl("the_geom"), geomType.getBinding(),
                geomType.getCoordinateReferenceSystem(),
                geomType.isIdentified(), geomType.isAbstract(),
                geomType.getRestrictions(), geomType.getSuper(),
                geomType.getDescription());

        GeometryDescriptor geomDesc = new GeometryDescriptorImpl(
                gt, new NameImpl("the_geom"),
                geom.getMinOccurs(), geom.getMaxOccurs(),
                geom.isNillable(), geom.getDefaultValue());

        attribs.add(0, geomDesc);

        SimpleFeatureType shpType = new SimpleFeatureTypeImpl(
                schema.getName(), attribs, geomDesc,
                schema.isAbstract(), schema.getRestrictions(),
                schema.getSuper(), schema.getDescription());


        shpDataStore.createSchema(shpType);

        if (featureSource instanceof SimpleFeatureStore) {
            SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;

            List<SimpleFeature> feats = new ArrayList<SimpleFeature>();

            FeatureIterator<SimpleFeature> features2 = features
                    .features();
            while (features2.hasNext()) {
                SimpleFeature f = features2.next();
                SimpleFeature reType = SimpleFeatureBuilder
                        .build(shpType, f.getAttributes(), "");

                feats.add(reType);
            }
            features2.close();
            SimpleFeatureCollection collection = new ListFeatureCollection(
                    shpType, feats);

            featureStore.setTransaction(transaction);
            try {
                List<FeatureId> ids = featureStore
                        .addFeatures(collection);
                transaction.commit();
            } catch (Exception problem) {
                problem.printStackTrace();
                transaction.rollback();
            } finally {
                transaction.close();
            }
            shpDataStore.dispose();
            return true;
        } else {
            shpDataStore.dispose();
            System.err.println("ShapefileStore not writable");
            return false;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}