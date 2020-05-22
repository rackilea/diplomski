public int executeMinnvsAtPQuery(String MinnvsAtP){
        String query = "SELECT SUM(MinnvsAt) FROM nfl.minnesota WHERE MinnvsAtP = ?";
        PreparedStatement stmt = conn[1].prepareStatement(minnvsAtPQuery);
        stmt.setString(1, MinnvsAtP);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1);
}

public int executeAtvsMinnQuery(String AtvsMinn){
        String query = "SELECT SUM(AtvsMinn) FROM nfl.minnesota WHERE MinnvsAtP = ?";
        PreparedStatement stmt = conn[1].prepareStatement(minnvsAtPQuery);
        stmt.setString(1, AtvsMinn);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1);
}