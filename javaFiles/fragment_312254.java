} catch( SQLException e ) {
    if( DerbyHelper.tableAlreadyExists( e ) ) {
        return; // That's OK
    }
    throw e;
}