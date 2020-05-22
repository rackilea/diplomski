btnAlteraImagem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        metodos met = new metodos();
        try {
            met.alterajlabel(Tela.this);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
});