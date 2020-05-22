PreparedStatement stm = null;
ResultSet rs = null;
for (String string : sql) {
    try {
        stm = con.prepareStatement(string);
        rs = stm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("usuario_senha"));
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
    }
}