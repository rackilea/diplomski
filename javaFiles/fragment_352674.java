try {
    stuff()
} catch( NullPointerException e ) {
   // Do nothing... go on
} catch( FileNotFoundException e ) {
   // Do nothing... go on
} catch( Exception e ) {
   // Now.. handle it!
}