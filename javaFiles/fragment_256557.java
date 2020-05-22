final String dbQuerry = "INSERT INTO test_table (TID,CREATED,OWNER,TITLE)\n" + 
        " VALUES (?,?,?, ?)\n" +
        " ON DUPLICATE KEY UPDATE\n" + 
        " CREATED=VALUES(CREATED), OWNER=VALUES(OWNER), TITLE=VALUES(TITLE)";

PreparedStatement st = mDBConnection.prepareStatement(dbQuerry);
st.setInt(1, Integer.valueOf(t.getParam("ID")));
st.setString(2, t.getParam("Date"));
st.setString(3, t.getParam("User"));
st.setString(4, t.getParam("Title"));