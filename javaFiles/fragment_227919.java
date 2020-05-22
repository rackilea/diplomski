PreparedStatement ps = connect.getConnection().prepareStatement("SELECT * FROM mbank.clients WHERE client_id = ?");
ps.setLong(1, client.getClient_id());    
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    String userid = rs.getString("id");
    String username = rs.getString("name"); 
}