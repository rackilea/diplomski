String sql = "SELECT t.name, t.surname, t.lecture ";
sql += "FROM studenttable t ";
sql += "WHERE t.school = 'CHC' AND " 
sql += "t.id = COALESCE(?, t.id) AND ";
sql += "t.entrolldate >= COALESCE(?, t.enrolldate) AND ";
sql += "t.graduationdate >= COALESCE(?, t.graduationdate)";

PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, studentInfo.getID());
ps.setDate(2, studentInfo.getStartDate());
ps.setDate(3, studentInfo.getEndDate());
ResultSet rs = ps.executeQuery();

while (rs.next()) {
    // process a row
}