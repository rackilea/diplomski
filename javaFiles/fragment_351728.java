btnIngresar = new JButton("Ingresar");
btnIngresar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        au = new AccionesUsuarios();
        au.iniciarSesion(textLoginUser, textLoginPass);

    }
});