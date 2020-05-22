private List<String> getColumnNames( String query, Connection conn )
{
    List<String> columnNames = new ArrayList<>();
    try
    {
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSetMetaData meta = ps.getMetaData();
        if ( meta != null )
        {
            for ( int i = 1; i <= meta.getColumnCount(); i++ ) //columns start with "1" not "0" for ResultSetMetaData.
            {
                columnNames.add( meta.getColumnName(i) );
            }
        }
    }
    catch ( SQLException e )
    {
        e.printStackTrace();
    }

    return columnNames;
}