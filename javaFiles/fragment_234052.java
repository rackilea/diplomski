btnAlteraImagem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        metodos met = new metodos();
        try {
            met.alterajlabel(lblImage);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
});