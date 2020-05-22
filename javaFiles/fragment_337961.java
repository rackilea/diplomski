Throwable throwable = null;
try {
    // do some stuff
}
catch( Throwable e ) {
    throwable = e;
}
finally {
    if( throwable != null ) {
        // handle it
    }
}