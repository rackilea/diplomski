st = con.prepareStatement( "ALTER SESSION SET NLS_TERRITORY='GREECE'" );
st.executeUpdate();
st.close();

st = con.prepareStatement( "SELECT 1.23, TO_CHAR( 1.23 ) FROM DUAL" );
ResultSet rs = st.executeQuery();
ResultSetMetaData md = rs.getMetaData();

System.out.println( md.getColumnTypeName( 1 ) + " " + md.getColumnTypeName( 2 ) );
while( rs.next() )
{
  System.out.println( rs.getString( 1 ) + " " + rs.getString( 2 ) );
}