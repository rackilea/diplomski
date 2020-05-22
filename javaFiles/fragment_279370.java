private void formWindowOpened(java.awt.event.WindowEvent evt) {
    jTable_Sections = new JTable(5, 5);
    jTable_Sections.setFillsViewportHeight(true);
    jScrollPane_Sections = new JScrollPane(jTable_Sections);
    jPanel_Grid.setLayout(new BorderLayout());
    jPanel_Grid.add(jScrollPane_Sections);
    this.validate();
    this.repaint();
    this.pack();
}