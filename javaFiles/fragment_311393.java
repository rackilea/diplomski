last
boolean last() throws SQLException
Moves the cursor to the last row in this ResultSet object.<be>

Returns:
 - true if the cursor is on a valid row;
 - false if there are no rows in the result set

Throws:
 - SQLException: if a database access error occurs; this method is called on a closed result set or the result set type is TYPE_FORWARD_ONLY

 - SQLFeatureNotSupportedException: if the JDBC driver does not support
   this method