public int validarLogin(String user, String pass) {
        int resultado = 0;
        if (user != null && pass != null) {
            resultado = admin.setUsuario(user, pass);
        }else {
            System.out.println("Incorrecto");
        }
        return resultado;
    }