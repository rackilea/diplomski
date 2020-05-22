void printObject( Object o ) {
    for ( Field fld : o.getClass().getDeclaredFields() ) {
        fld.setAccessible( true );
        Object oFldVal = fld.get( o );
        if ( fld.getType().isArray() ) {
            int iLen = Arrays.getLength( oFldVal );
            for ( int i = 0; i < iLen; ++i ) {
                printObject( Arrays.get( oFldVal, i ) );
            }
        } else {
            System.println( oFldVal );
        }
    }
}