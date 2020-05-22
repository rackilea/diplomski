/**
 * Get the major version of the ODS (On-Disk Structure) of the database.
 * 
 * @return The major version number of the database itself
 * @exception SQLException if a database access error occurs
 */
int getOdsMajorVersion() throws SQLException;

/**
 * Get the minor version of the ODS (On-Disk Structure) of the database.
 * 
 * @return The minor version number of the database itself
 * @exception SQLException if a database access error occurs
 */
int getOdsMinorVersion() throws SQLException;

/**
 * Get the dialect of the database.
 *
 * @return The dialect of the database
 * @throws SQLException if a database access error occurs
 * @see #getConnectionDialect()
 */
int getDatabaseDialect() throws SQLException;

/**
 * Get the dialect of the connection.
 * <p>
 * The connection dialect may be different from the database dialect.
 * </p>
 *
 * @return The dialect of the connection
 * @throws SQLException if a database access error occurs
 * @see #getDatabaseDialect()
 */
int getConnectionDialect() throws SQLException;