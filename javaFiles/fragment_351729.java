public void iniciarSesion(String user, String pass){
    dataLogin = new iniciarSesionw();
    String usr = "", pwd = "";
    usr = user.trim();
    pwd = pass.trim();

    System.out.println("Usuario: "+usr);
    System.out.println("Contraseña: "+pwd);
/*try {
        conn.openConnection();

        /*dataLogin = new iniciarSesionw();
        String username = usr;
        String password = pwd;

        ComandoBaseDatos comando = new ComandoBaseDatos("SELECT * FROM Usuarios_Operadores WHERE Usuario = '123' AND Clave = '123'");
        ResultSet rs = comando.SQLExecute();

        while (rs.next()) {
            JOptionPane.showMessageDialog(null, "Correcto!");
        }
        conn.closeConnection();
    } catch (SQLException ex) {
        conn.getSqlMessage(ex);
    }*/