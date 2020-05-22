// Get the metadata
  ResultSetMetaData md = rs.getMetaData() ;

  // Print the column labels
  for( int i = 1; i <= md.getColumnCount(); i++ )
     System.out.print( md.getColumnLabel(i) + " " ) ;
  System.out.println() ;