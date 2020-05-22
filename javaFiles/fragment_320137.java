JMenuItem modifier = new JMenuItem("Modifier le prix");
modifier.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Controleur.supprimerLigne(panelSource, ligneCompte);
        System.out.println("modifier");
    }
});