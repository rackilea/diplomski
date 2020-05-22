Object[][] rows = {
    {element,symbol,atomicNumber,atomicMass,valence}
};
Object[] cols = {
    "Name","Symbol","Atomic Number","Atomic Mass", "# of Valence Electrons"
};
JTable table = new JTable(rows, cols);
JOptionPane.showMessageDialog(null, new JScrollPane(table));