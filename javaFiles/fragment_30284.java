public class DbUnitModule extends org.unitils.dbunit.DbUnitModule implements Module {
    /*
     * (non-Javadoc)
     * 
     * @see org.unitils.dbunit.DbUnitModule#getDbUnitDatabaseConnection(java.lang.String)
     */
    @Override
    public DbUnitDatabaseConnection getDbUnitDatabaseConnection(final String schemaName) {
        DbUnitDatabaseConnection dbConnection = super.getDbUnitDatabaseConnection(schemaName);
        dbConnection.getConfig().setProperty("http://www.dbunit.org/properties/tableType", new String[] { "VIEW", "TABLE" });
        return dbConnection;
    }
}