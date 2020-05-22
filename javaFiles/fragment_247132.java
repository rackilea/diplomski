final OracleResultSet results    = statement.getCursor( 1 );
final ResultSetMetaData metadata = results.getMetadata();
final int columns                = metadata.getColumnCount();
final String[] colNames          = new String[ columns ];
final String[] sqlColTypeNames   = new String[ columns ];
final int[] sqlColTypes          = new int[ columns ];
final boolean[] caseSensitive    = new boolean[ columns ];

for ( int i = 1; i <= columns; i++ )
{
  colNames[i-1]        = metadata.getColumnName( i );
  sqlColTypeNames[i-1] = metadata.getColumnTypeName( i );
  sqlColTypes[i-1]     = metadata.getColumnType( i );
  caseSensitive[i-1]   = metadata.isCaseSensitive( i );
}
final QueryTable table = new QueryTable(
  0,
  colNames,
  sqlColTypeNames,
  sqlColTypes
);
table.getMeta().setColumnCase( caseSensitive );

int rows = 0;
while ( results.next() )
{
  table.addRows( 1 );
  ++rows;
  for ( int c = 1; c <= columns; ++c )
  {
    Object value = null;
    switch( sqlColTypes[c-1] )
    {
      case OracleTypes.ARRAY:   value = results.getARRAY( c ).getArray();
                                break;
      case OracleTypes.VARCHAR: value = results.getString( c );
                                break;
      case OracleTypes.DATE:    value = results.getDate( c );
                                break;
      case OracleTypes.NUMERIC: value = results.getBigDecimal( c );
                                break;
      // Add other types
      default:                throw new UnsupportedOperationException( "Unable to handle: " + sqlColTypes[c-1] );
    }
    if ( results.wasNull() )
    {
      value = null;
    }
    table.setField( rows, c, value );
  }
}