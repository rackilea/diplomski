int resultado = u.validarLogin(jtxtUsuario.getText(), String.valueOf(jpsfContrasenia.getPassword()));
    if (resultado == 1) {
        new jfrmInterno().setVisible(true);
    } else {
        JOptionPane.showMessageDialog(null, "El nombre de usuario ingresado no coincide con ninguna cuenta", "", JOptionPane.ERROR_MESSAGE);
        jtxtUsuario.setText("");
        jpsfContrasenia.setText("");
    }
}