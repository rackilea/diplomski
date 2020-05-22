private static List<Date> getDates(Connection conn) throws SQLException {
    List<Date> list = new ArrayList<Date>();
    StringBuilder sb = new StringBuilder();
    Statement st = conn.createStatement();
    st.execute("select distinct(Date) from DbTable");
    ResultSet rset = st.getResultSet();
    while (rset.next()) {
        list.add(rset.getDate(1));
    }
    return list;
}