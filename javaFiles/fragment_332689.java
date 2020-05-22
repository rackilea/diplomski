PreparedStatement pstmt = connection.prepareStatement(...);
// ...
boolean result = pstmt.execute();
while(true)
    if (result) {
        ResultSet rs = pstmt.getResultSet();
        // Do something with resultset ...
    } else {
        int updateCount = pstmt.getUpdateCount();
        if (updateCount == -1) {
            // no more results
            break;
        }
        // Do something with update count ...
    }
    result = pstmt.getMoreResults();
}