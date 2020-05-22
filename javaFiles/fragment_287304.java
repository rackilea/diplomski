import java.sql.Connection;
import java.sql.PreparedStatement;

//...

String sql = "insert into score (player, score) values (?, ?)";
Connection connection = new getConnection();  //use a connection pool
PreparedStatement ps = connection.prepareStatement(sql);  //prefer this over statement

for (Player player: players) {  //in case you need to iterate through a list

    ps.setString(1, player.getName());   //implement this as needed
    ps.setString(2, player.getScore());   //implement this as needed
    ps.addBatch();  //add statement to batch
}
ps.executeBatch();  //execute batch
ps.close();  //close statement
connection.close();  //close connection (use a connection pool)