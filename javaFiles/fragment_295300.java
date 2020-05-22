void printObject( Object o ) {
    for ( Field fld : o.getClass().getDeclaredFields() ) {
        fld.setAccessible( true );
        System.out.println( fld.get( o ) );
    }
}