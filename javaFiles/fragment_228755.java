/**
 * Gets the designated column's table name. 
 *
 * @param column the first column is 1, the second is 2, ...
 * @return table name or "" if not applicable
 * @exception SQLException if a database access error occurs
 */
String getTableName(int column) throws SQLException;