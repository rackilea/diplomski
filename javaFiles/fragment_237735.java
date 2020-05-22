String sql = "SELECT FIRST_NAME, LAST_NAME, HOURS FROM WORKERS WHERE ID= ?";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstml.setInt(1, 007859378);
ResultSet rs = pstmt.executeQuery();

while(rs.next()){
   //Extract values from ResultSet
}