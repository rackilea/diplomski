File f = new File ( "world.shp" );
    ShapefileDataStore dataStore = new ShapefileDataStore ( f.toURI ().toURL () );
    FeatureSource<SimpleFeatureType, SimpleFeature> featureSource = 
        dataStore.getFeatureSource ();
    String geomAttrName = featureSource.getSchema ()
        .getGeometryDescriptor ().getLocalName ();

    ResourceInfo resourceInfo = featureSource.getInfo ();
    CoordinateReferenceSystem crs = resourceInfo.getCRS ();
    Hints hints = GeoTools.getDefaultHints ();
    hints.put ( Hints.JTS_SRID, 4326 );
    hints.put ( Hints.CRS, crs );

    FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2 ( hints );
    GeometryFactory gf = JTSFactoryFinder.getGeometryFactory ( hints );

    Coordinate land = new Coordinate ( -122.0087, 47.54650 );
    Point pointLand = gf.createPoint ( land );
    Coordinate water = new Coordinate ( 0, 0 );
    Point pointWater = gf.createPoint ( water );

    Intersects filter = ff.intersects ( ff.property ( geomAttrName ), 
        ff.literal ( pointLand ) );
    FeatureCollection<SimpleFeatureType, SimpleFeature> features = featureSource
            .getFeatures ( filter );

    filter = ff.intersects ( ff.property ( geomAttrName ), 
        ff.literal ( pointWater ) );
    features = featureSource.getFeatures ( filter );