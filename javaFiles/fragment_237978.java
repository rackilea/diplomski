private static final String GET_MY_INFO = "SELECT nombre_pdv, SUM(total) " +
                                          "FROM venta_platillos " +
                                          "WHERE fecha = ? " +
                                          "GROUP BY nombre_pdv";
...
StringBuilder sb = new StringBuilder();
try (
    PreparedStatement stmt = dBConnection.prepareStatement(GET_MY_INFO);
) {
    stmt.setX(1, fetcha);
    ...
    try (
        ResultSet rset = stmt.executeQuery();
    ) {
        while (rset.next()) {
            sb.append(rset.getString(1) +"\n"+ rset.getString(2)+"\n");
        }
    }
}
// use sb as you want
...