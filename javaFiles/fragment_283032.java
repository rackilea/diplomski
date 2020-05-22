final JTable table = new JTable(10, 5) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        Dimension dim = super.getPreferredScrollableViewportSize();
        // here we return the pref height
        dim.height = getPreferredSize().height;
        return dim;
    }

};
final JComponent content = new JPanel();
content.add(new JScrollPane(table));
Action add = new AbstractAction("add row") {

    @Override
    public void actionPerformed(ActionEvent e) {
        ((DefaultTableModel) table.getModel()).addRow(new Object[]{});
        content.revalidate();
    }
};