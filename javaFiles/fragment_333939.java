// 'conn' is your JDBC connection
Statement stmt = conn.createStatement();
PreparedStatement update = conn.prepareStatement(
    "UPDATE maintable SET famousQuote=tempString3 WHERE hashKey=tempString2";    
String sqlStatement = "Select * FROM mainTable ORDER BY famousName";
ResultSet rs = stmt.executeQuery(sqlStatement);
while(rs.next()){
     tempString1 = rs.getString("famousQuote");
     tempString2 = rs.getString("hashKey");
     tempString3 = EncryptionAlgorithm.EncryptStatement(tempString1, tempString2);
     update.setObject(1, tempString3);
     update.setObject(2, tempString2);
     update.executeUpdate(sqlStatement);
}