public void crearAtleta(String dni, String nombre, 
        String apellidos, char genero, 
        Date nacimiento, String correo,
        String telefono, String codigoFederacion) throws SQLException {

    PreparedStatement ps = null;

    try {
        ps = Jdbc.getConnection().prepareStatement(SQL_CREAR_ATLETA);

        Integer idAtleta = calcularIdAtleta();

        ps.setString(1, String.valueOf(idAtleta));
        ps.setString(2, nombre);
        ps.setString(3, apellidos);
        ps.setString(4, String.valueOf(genero));
        ps.setDate(5, new java.sql.Date(nacimiento.getTime()));
        ps.setString(6, dni);
        ps.setString(7, correo);
        ps.setString(8, telefono);
        ps.setString(9, codigoFederacion);
        ps.execute();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (ps != null) {
            ps.close();
        }
    }    
}