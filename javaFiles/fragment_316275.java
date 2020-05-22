PreparedStatement pstmnt  = connection.prepareStatement
("insert into Usernames(`ID`,`Username`,`Password`,`Account type`, `salt`) values (?,?,?,?,?,)");
pstmnt.setInt(1, id); //would ideally be auto-incremented
pstmnt.setString(2, user); //user String obtained by any means
pstmnt.setString(3, securePassword); //from the hash/salt example above
pstmnt.setString(4, accType); //whatever naming structure you have for account types
pstmnt.setString(5, salt); //from the above example also.
pstmnt.executeUpdate();