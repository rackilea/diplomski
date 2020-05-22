String sql = "INSERT INTO `ad`.`ad` (`imgURL`, `linkURL`, `client`, `idx`) VALUES (?, ?, ?, ?)";
final PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, a.getImgURL()) ;
statement.setString(2, a.getLinkURL()) ;
statement.setString(3, a.getClient()) ;
statement.setString(4, a.getIdx());
final ResultSet results = statement.executeQuery();