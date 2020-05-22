Connection conn = DriverManager.getConnection(url);
String insert = "INSERT INTO Persons (Name,Surname,ID,Phone) values (?,?,?,?);";
PreparedStatement pStmnt = conn.prepareStatement(insert);
pstmnt.setString(1,a.getName());
pstmnt.setString(2,a.getSurname());
pStmnt.setInt(3,a.getId());
pStmnt.setString(3,a.getPhone());

pStmnt.execteUpdate();