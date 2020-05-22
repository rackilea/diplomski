String query = "select * from users";
ConnectToDB c = new ConnectToDB();
try (
    Connection conn = c.connectToDB();
    PreparedStatement stmt = conn.prepareStatement(query);
) {
    ResultSet set = stmt.executeQuery();

    while(set.next()){
        users.add(new Utente(set.getInt("id"),
                             set.getString("name"),
                             set.getString("surname"),
                             set.getString("email"),
                             set.getString("password"),
                             set.getString("imgURL"),
                             set.getString("orgURL"),
                    (Boolean)set.getObject("isAuthor")));
    }
}