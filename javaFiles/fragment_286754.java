public static void insertNewUser(String id,String first_name,String last_name, String email,String password){
connection conn = getConnection();
PreparedStatment create = conn.prepareStatement("Insert into admin Values ?,?,?,?,?" );
PreparedStatment.setString(1,id);
PreparedStatment.setString(2,first_name);
PreparedStatment.setString(3,last_name);
PreparedStatment.setString(4,email);
PreparedStatment.setString(5,password);
PreparedStatment.exectueUpdate();