static Set<String> valueSet;

static {
    valueSet = new HashSet<String>();
    valueSet.add("Administrador");
    valueSet.add("Financeiro");
    valueSet.add("Operacional");
}

public void Logar() {
    Set<String> result = new HashSet<String>();

    String sql = "Select usuario_login, senha_login, nome_login, nivelAcesso from nivelAcessoSistema natural join login group by nivelAcesso having usuario_login = ? and senha_login = ?";

    try {

        pst = con.prepareStatement(sql);

        pst.setString(1, txtUsuario.getText()); //Campo do usuário
        pst.setString(2, txtSenha.getText()); //Campo da senha

        rs = pst.executeQuery();

        while (rs.next()) { //Se existe registro no banco de dados com os dados informados na tela de login...

            String nivelAcesso = rs.getString("nivelAcesso"); //Comparando valor de atríbuto "nivelAcesso" do banco de dados

            result.add(nivelAcesso);
        }

        if (valueSet.containsAll(result)) {

            JOptionPane.showMessageDialog(null, "OK");
        }

        else {
            JOptionPane.showMessageDialog(null, "Wrong");
        }
    }