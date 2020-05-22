jComboBox1.setRenderer(new DefaultListCellRenderer() {
    @Override
    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        super.paint(g);
    }
});