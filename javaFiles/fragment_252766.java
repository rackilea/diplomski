public MainView() {
    JPanel panelFenetre = new JPanel(new GridBagLayout());
    add(panelFenetre);

    // setVisible(true);
    // panelFenetre.setVisible(true);
    // setSize(dimensionFenetre);

    panelFenetre.add(new JScrollPane(getTable1()), getTable1Constraints());        
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
}