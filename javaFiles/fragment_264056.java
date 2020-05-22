public void loadObjects() {
    try (
        Statement st = getConnection().createStatement();
        //- As you read (later) only id, then why to use '*' in this query? It only takes up resources.
        ResultSet rs = st.executeQuery("SELECT id FROM Administrator");
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM Userx WHERE ID = ?");
        ResultSet r2 = null;
    ) {
        while (rs.next()) {
            Administrator user = new Administrator();
            user.ID = rs.getString("id");
            ps.setInt(1, user.ID);
            r2 = ps.executeQuery();
            if (r2.next()) {
                user.name = r2.getString(2);
                user.surname = r2.getString(3);
                user.PIN = r2.getLong(4);
                JBDeveloping.users.administrators.add(user);
            }
            else {
                System.out.println("User with ID=" + user.ID + " was not found.");
            }
        }
    }
    catch (Exception x) {
        x.printStacktrace();
    }
}