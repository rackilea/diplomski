try{
 String sqlSelectTable2 = "SELECT * FROM table2;";
 ResultSet rs = stmt.executeQuery(sqlSelectTable2); 
 while (rs.next()) {
       String strLineId = rs.getString(1);
       String strPoints = rs.getString(2);
       PreparedStatement preparedStatement = null;
       String sqlWithin = "SELECT ST_Within(ST_GeometryFromText('POINT( ),ST_GeomFromText('POLYGON((443425 4427680, 441353 4427680, 441368 4426075, 443762 4426149, 443425 4427680))', 4326));";

       preparedStatement = dbConnection.prepareStatement(sqlWithin);
       ResultSet rsWithin = preparedStatement.executeQuery();
} // end while ... **It get error when it is reading second ResultSet **
} catch (Exception e) {
System.out.println(e.getMessage());
}