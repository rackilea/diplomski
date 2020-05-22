Transaction transaction = new transaction("insert");
try {
     SimpleFeatureStore featureStore =
           (SimpleFeatureStore) wfs.getFeatureSource( typeName );
     featureStore.setTransaction( transaction );
     featureStore.addFeatures( DataUtilities.collection( feature ) );

     transaction.commit();

     // get the final feature id
     WFSTransactionState wfsts = (WFSTransactionState) transaction.getState(wfs);

     // In this example there is only one fid. Get it.
     String result = wfsts.getFids( typeName )[0];
}
finally {
     transaction.close();
}