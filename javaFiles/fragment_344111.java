public static void main(String[] args) throws Exception {
    Connection myCon = null;
    try {
        String userName = "myuser", password = "mypass";// change accordingly
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";// change accordingly
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        myCon = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStmt;
        try {
            String sql = "INSERT INTO table2 (text, id) values (?,?)";
            preparedStmt = myCon.prepareStatement(sql);
            preparedStmt.setString(1, "/ˈaɪfoʊn/ eye-fohn)");
            preparedStmt.setInt(2, 1);
            preparedStmt.executeUpdate();   
            preparedStmt = myCon.prepareStatement("SELECT id, text as text from table2 ");
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                System.out.println("-->" +rs.getString("text") + "<--");
            }           
            preparedStmt.close();               
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    } finally {
        if (myCon != null) {
            try {
                myCon.close();
            } catch (Exception e) { }
        }
    }
}