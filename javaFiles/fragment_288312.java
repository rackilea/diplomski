public void insertArticle(String title, String content) {
    Connection con  = null;
    PreparedStatement  stmt = null;

    String request = "insert into database_name.articles (title, content) values (?, ?)";

    try {
        con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        stmt = con.prepareStatement(request);
        stmt.setString(1, title);
        stmt.setString(2, content);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (stmt != null) try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null) try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}