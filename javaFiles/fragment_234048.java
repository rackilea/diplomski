btnAlteraImagem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        metodos met = new metodos(Tela.this);
        try {
            met.alterajlabel();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
});