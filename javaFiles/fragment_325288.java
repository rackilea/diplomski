FeatureIterator i = featureCollection.features()
 try {
    while( i.hasNext() ){
        SimpleFeature feature = i.next();
    }
 }
 finally {
    i.close();
 }