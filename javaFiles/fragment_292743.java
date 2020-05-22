Connection con = null;
try {
    con = ... //retrieve the database connection
    //do your work...
} catch (SQLException e) {
    //handle the exception
} finally {
    try {
        if (con != null) {
            con.close();
        }
    } catch (SQLException shouldNotHandleMe) {
        //...
    }
}