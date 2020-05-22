String checkSql = "select count(*) from HIGHSCORES where name = '"+name+"'";

Statement st = con.createStatement();
ResultSet result = st.executeQuery(checkSql);
result.next();
if ( result.getInt(1) == 0) {
  System.out.println("doesn't exist");
} else {
  System.out.println("exists");
}