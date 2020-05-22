int count = 0;
try {
    String sql = "SELECT COUNT(*) AS rCount FROM tbl_padre";
    Statement st = cx.createStatement();
    ResultSet r = st.executeQuery(sql);
    while (r.next()) {
        count = r.getInt("rCount");
    }
    r.close();
    st.close();
    // Close your DB connection as well if desired.
    // yourConnection.close();

    //To apply this value to your JTextField:
    pruebamax.setText(String.valueOf(count));

    System.out.println("Total number of records in the tbl_padre " +
                       " table is: " + count);
}
catch (SQLException ex) {
    ex.printStackTrace();
}