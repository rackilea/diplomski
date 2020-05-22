conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.setAutoCommit(false);

Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("SELECT token_id FROM tokens ORDER BY token_id LIMIT 1 FOR UPDATE");
rs.next();
int token_id = rs.getInt("token_id");
System.out.printf("Got %d.%n", token_id);
PreparedStatement ps = conn.prepareStatement("DELETE FROM tokens WHERE token_id=?");
ps.setInt(1, token_id);
ps.executeUpdate();
conn.commit();