conn = BDConnexion.ConnecterBD();
String selectSQL = "select * from persons where nom=? and prenom=?";
PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
preparedStatement.setString(1, nom);
preparedStatement.setString(2, prenom);
ResultSet rs = preparedStatement.executeQuery(selectSQL);
while (rs.next()) {
   ....