for ( int i = 0; i < instances.numInstances(); i++ ) {
    // for each cluster center
    Instance inst = instances.instance( i );
    // as you mentioned, you only had 1 attribute
    // but you can iterate through the different attributes
    double value = inst.value( 0 );
    System.out.println( "Value for centroid " + i + ": " + value );
}