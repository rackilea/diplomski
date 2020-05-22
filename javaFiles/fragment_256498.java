ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM myTable");
ResultSetMetaData rsmd = rs.getMetaData();
int nullable = rsmd.isNullable(1);
if(nullable == ResultSetMetadata.columnNullable) {
    System.out.println("Nullable");
}