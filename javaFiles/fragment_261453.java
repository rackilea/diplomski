PreparedStatement ps = null;
String query  = "select S.StatusDesc as sc ";
       query += "from application A ";
       query += "inner join StatusMaster S ";
       query += "on A.StatusMasterId = S.StatusMasterId ";
       query += "and A.ApplicationNumber = ?";
ps = conn.prepareStatement(query);
ps.setString(1, applicationNumber);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
    columnValue = rs.getString("sc");
    return columnValue;
}