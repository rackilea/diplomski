DynamoDB con = null;
try {
    con = getDynamoDBConnection();
    // Do whatever you need to do with con
} catch (ApplicationSpecificException e) {
    // deal with it gracefully
} finally {
    if (con != null)
        con.shutdown();
}