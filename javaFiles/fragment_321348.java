public void registraUtente(String nomeDaRegistrare, String cognomeDaRegistrare,String emailDaRegistrare, int tipoDaRegistrare, String passwordDaRegistrare) throws SQLException {
    Connection con = DBConnectionPool.getConnection();
    PreparedStatement ps = null;
    try {
        String query = "INSERT INTO utenti(nome,cognome,email,tipo,password) VALUES(?,?,?,?,?)";
        ps = con.prepareStatement(query);
        ps.setString(1, nomeDaRegistrare);
        ps.setString(2, cognomeDaRegistrare);
        ps.setString(3, emailDaRegistrare);
        ps.setInt(4, tipoDaRegistrare);
        ps.setString(5, passwordDaRegistrare);
        ps.executeUpdate();
        con.commit();
    }
    finally {
        if (ps != null) {
            try {
                ps.close();
            }
            catch (SQLException ignored) {
            }
        }
        try {
            con.close();
        }
        catch (SQLException ignored) {
        }
    }
}