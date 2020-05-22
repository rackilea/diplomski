@Override
public List<User> read(Connection conn) {
    List<User> list = new ArrayList<>();
    System.out.println("Reading users from the database...");
    try {
        Statement st = conn.createStatement(); 
        String query = "SELECT * FROM Users";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String emailAddress = rs.getString("emailAddress");
            String password = rs.getString("password");

            User user = new User(firstName, lastName, emailAddress, password);
            list.add(user);
        }           
        rs.close();
        st.close();
    } catch (SQLException ex) {
        System.out.println("Exception:" + ex.toString()); 
    }
    return list;
}