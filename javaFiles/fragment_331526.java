try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = (Connection)  DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mafia?useUnicode=true&characterEncoding=utf8", "root", "qwerty");
    Statement st2 = con.createStatement();

    st2.executeUpdate("SET @Rank = 0");

    ResultSet result2 = st2.executeQuery("SELECT t.*, @Rank := @Rank + 1 AS rank \n" +
        "FROM (SELECT id_user,(SELECT surname FROM users WHERE id_user=id),(SELECT name FROM users WHERE id_user=id), (SELECT nickname FROM users WHERE id_user=id),SUM(points) AS points FROM RESULT \n" +
        "GROUP BY id_user ORDER BY  points asc) t");

    while (result2.next()) {
        ((DefaultTableModel) jTable1.getModel()).addRow(new Object[] {
            result2.getString(1), result2.getString(2), result2.getString(3), result2.getString(4), result2.getString(5), result2.getString(6)
        });

    }
    result2.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
    e.printStackTrace();
    System.exit(1);
}