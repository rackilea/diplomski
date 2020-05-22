String insertsql1 = "INSERT INTO ng_albums(ng_singers_id) SELECT 
     ng_singers.ng_singers_id FROM ng_singers WHERE ng_singers.name= ?";

PreparedStatement ps1=(PreparedStatement) conn.prepareStatement(insertsql1);
ps1.setString(1, data[0]);

ps1.executeUpdate();