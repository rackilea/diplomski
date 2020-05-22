String message = "Example of fetching Timestamp from Postgres.";
StringBuilder sql = new StringBuilder();
sql.append( "SELECT now() " + "\n" );
sql.append( ";" );
java.sql.Timestamp ts = null;
try ( Connection conn = DatabaseHelper.instance().connectionInAutoCommitMode() ; 
        PreparedStatement pstmt = conn.prepareStatement( sql.toString() ); ) {
    try ( ResultSet rs = pstmt.executeQuery(); ) {
        // Extract data from result set
        int count = 0;
        while ( rs.next() ) {
            count ++;
            ts = rs.getTimestamp( 1 );
        }
    }

} catch ( SQLException ex ) {
    logger.error( "SQLException during: " + message + "\n" + ex );
} catch ( Exception ex ) {
    logger.error( "Exception during: " + message + "\n" + ex );

}