public String studentName(String rollNo) throws SQLException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rst = null;
    String names = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port/servicename","username","password");
        stm = con.prepareStatement("select student_name,father_name from student_db where roll_no=?");
        stm.setString(1,  rollNo);
        rst = stm.executeQuery();
        if (rst.next())
            names = rst.getString(1)+","+rst.getString(2);
        rst.close();
        rst = null;
        stm.close();
        stm=null;
        con.close();
        con = null;
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        if (rst!=null) rst.close();
        if (stm!=null) stm.close();
        if (con!=null) con.close();
    }
    return names;
}