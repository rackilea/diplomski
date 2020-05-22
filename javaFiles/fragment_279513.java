query = "SELECT * FROM POST_COMMENT WHERE Post_date_time = ? AND Post_User = ?;";

PreparedStatement pstm = con.prepareStatement(query);
pstm.setDate(1, post.getDatetime());
pstm.setInt(2, post.getPublisher().getID());
ResultSet rs = pstm.executeQuery();