Scan scanner = new Scan();

    SingleColumnValueFilter filter = new SingleColumnValueFilter(
        Bytes.toBytes( "some family" ),
        Bytes.toBytes( "some column" ),
        CompareFilter.CompareOp.EQUAL,
        Bytes.toBytes( "" )
    );
    filter.setFilterIfMissing( false );

    scanner.setFilter( filter );
    return scanner;